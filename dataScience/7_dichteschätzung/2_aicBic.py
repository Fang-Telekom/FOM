import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

# optimale Anzahl der Komponenten
# Kreuzvalidierung einsetzen, um eine Überanpassung zu verhindern.
# AIC   Akaike Informationskriteriums

# BIC   bayesschen Informationskriteriums

from sklearn import mixture
from sklearn.datasets import make_moons
from matplotlib.patches import Ellipse

def plot_gmm(gmm, X, label=True, ax=None):
    ax = ax or plt.gca()
    labels = gmm.fit(X).predict(X)
    if label:
        ax.scatter(X[:, 0], X[:, 1], c=labels, s=40, cmap='viridis', zorder=2, alpha=0.5)
    else:
        ax.scatter(X[:, 0], X[:, 1], s=40, zorder=2, alpha=0.5)
    ax.axis('equal')

Xmoon, ymoon = make_moons(200, noise=.05, random_state=0)

n_components = np.arange(1, 21)
models = [mixture.GaussianMixture(n, covariance_type='full', random_state=0).fit(Xmoon) for n in n_components]
plt.plot(n_components, [m.bic(Xmoon) for m in models], label='BIC')
plt.plot(n_components, [m.aic(Xmoon) for m in models], label='AIC')
plt.legend(loc='best')
plt.xlabel('Anzahl der Komponenten')

plt.show()