import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

# Gauß’sche Mixture-Modell (GMM)
# Erweiterung des K-Means Algorithmus

from sklearn import mixture
# from sklearn.mixture import GMM # cannot import name 'GMM' from 'sklearn.mixture‘
from sklearn.datasets import make_blobs

X, y = make_blobs(n_samples=300, centers=4, cluster_std=0.70, random_state=0)
gmm = mixture.GaussianMixture(n_components=4).fit(X)
#gmm = GMM(n_components=4).fit(X)
labels = gmm.predict(X)

# proportional Größe zur Zuversicht
# Nähe der ClusterGrenzen -> geringere Wahrscheinlichkeiten
probs = gmm.predict_proba(X)
print(probs[:5].round(3))
size = 50 * probs.max(1) ** 2

plt.scatter(X[:, 0], X[:, 1], c=labels, s=size, cmap='viridis')




plt.show()