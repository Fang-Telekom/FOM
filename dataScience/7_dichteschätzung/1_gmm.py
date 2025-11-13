import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

# Gauß’sche Mixture-Modell (GMM)
# Dichteschätzung: Auf Cluster mit nichtlinearen Grenzen angewandt

from sklearn import mixture
from sklearn.datasets import make_moons
from matplotlib.patches import Ellipse

def draw_ellipse(position, covariance, ax=None, **kwargs):
    """Draw an ellipse with a given position and covariance"""
    ax = ax or plt.gca()
    
    # Convert covariance to principal axes
    if covariance.shape == (2, 2):
        U, s, Vt = np.linalg.svd(covariance)
        angle = np.degrees(np.arctan2(U[1, 0], U[0, 0]))
        width, height = 2 * np.sqrt(s)
    else:
        angle = 0
        width, height = 2 * np.sqrt(covariance)
    
    # Draw the Ellipse
    for nsig in range(1, 4):
        ax.add_patch(Ellipse(xy=position, width=nsig * width,height= nsig * height,
                             angle=angle, **kwargs))
        
def plot_gmm(gmm, X, label=True, ax=None):
    ax = ax or plt.gca()
    labels = gmm.fit(X).predict(X)
    if label:
        ax.scatter(X[:, 0], X[:, 1], c=labels, s=40, cmap='viridis', zorder=2, alpha=0.5)
    else:
        ax.scatter(X[:, 0], X[:, 1], s=40, zorder=2, alpha=0.5)
    ax.axis('equal')
    
    w_factor = 0.2 / gmm.weights_.max()
    for pos, covar, w in zip(gmm.means_, gmm.covariances_, gmm.weights_):
        draw_ellipse(pos, covar, alpha=w * w_factor)


Xmoon, ymoon = make_moons(200, noise=.05, random_state=0)

# Keine Cluster Finden
# Modellierung der Verteilung von Eingabedaten
# Hilft bei Erstellung ähnliche Daten
gmm = mixture.GaussianMixture(n_components=16, random_state=0, covariance_type='full')

plot_gmm(gmm, Xmoon, label=False)

Xnew, label = gmm.sample(400)
plt.scatter(Xnew[:, 0], Xnew[:, 1])
# Xnew = gmm.sample(400)
# plt.scatter(Xnew[0][:, 0], Xnew[0][:, 1])

plt.show()