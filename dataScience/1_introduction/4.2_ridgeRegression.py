import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.base import BaseEstimator, TransformerMixin
from sklearn.linear_model import LinearRegression, Ridge
from sklearn.pipeline import make_pipeline

class GaussianFeature (BaseEstimator, TransformerMixin):
    # Gleichmäßig verteilte Gauß’sche Merkmale für eindimensionale Eingaben
    def __init__(self, N, width_factor=2.0):
        self.N = N
        self.width_factor = width_factor
    @staticmethod
    def _gauss_basis(x, y, width, axis=None):
        arg = (x - y) / width
        return np.exp(-0.5 * np.sum(arg ** 2, axis))
    def fit(self, X, y=None):
        # N auf den Wertebereich verteilte Zentren
        self.centers_ = np.linspace(X.min(), X.max(), self.N)
        self.width_ = self.width_factor * (self.centers_[1] - self.centers_[0])
        return self
    def transform(self, X):
        return self._gauss_basis(X[:, :, np.newaxis], self.centers_, self.width_, axis=1)
    
#Koeffizienten
def basis_plot(model, title=None):
    fig, ax = plt.subplots(2, sharex=True)
    model.fit(x[:, np.newaxis], y)
    ax[0].scatter(x, y)
    ax[0].plot(xfit, model.predict(xfit[:, np.newaxis]))
    ax[0].set(xlabel="x", ylabel="y", ylim=(-1.5, 1.5))
    if(title):
        ax[0].set_title(title)
    ax[1].plot(model.steps[0][1].centers_, model.steps[1][1].coef_)
    ax[1].set(xlabel="basis location", ylabel="coefficient", xlim=(0, 10))
    

rng = np.random.RandomState(1)
x = 10 * rng.rand(50)
y = np.sin(x) + 0.1 * rng.randn(50)
xfit = np.linspace(0, 10, 1000)
# Ridge -> L2-Regularisierung/Tikhonov-Regularisierung
# LinearRegression() - Überanpassung
# Alpha Steuerung der Komplexität des resultierenden Modells
#   -> 0 normale lineare Regression | -> unendlich Reaktion unterdrückung
gauss_model = make_pipeline(GaussianFeature(30), Ridge(alpha=0.1))

basis_plot(gauss_model, title="Ridge-Regression")

plt.show()