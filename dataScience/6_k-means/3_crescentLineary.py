import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.cluster import KMeans
from sklearn.datasets import make_moons
from sklearn.cluster import SpectralClustering

X, y = make_moons(200, noise=.05, random_state=0)

model = SpectralClustering(n_clusters=2, affinity="nearest_neighbors", assign_labels="kmeans")
#model = KMeans(n_clusters=2, random_state=0)
labels = model.fit_predict(X)
plt.scatter(X[:, 0], X[:, 1], c=labels, s=50, cmap='viridis')
#centers = model.cluster_centers_
#plt.scatter(centers[:, 0], centers[:, 1], c='black', s=200, alpha=0.5)
plt.show()