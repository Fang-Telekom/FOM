import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

# PCA (Principal Component Analysis) = Hauptkomponentenanalyse
# PCA -> Dimensionsreduktionsalgorithmus
# Auch zur Verwendung für Visualisierung, Rauschunterdrückung, Merkmalsextraktion, Merkmalserstellung, etc.

from sklearn.decomposition import PCA


def draw_vector(v0, v1, ax=None):
    ax = ax or plt.gca()
    arrowprops=dict(arrowstyle='->',
                    linewidth=2,
                    shrinkA=0, shrinkB=0)
    ax.annotate('', v1, v0, arrowprops=arrowprops)


rng = np.random.RandomState(1)
X = np.dot(rng.rand(2, 2), rng.randn(2, 200)).T

pca = PCA(n_components=2)
pca.fit(X)

plt.scatter(X[:, 0], X[:, 1], alpha=0.2)
for length, vector in zip(pca.explained_variance_, pca.components_):
    v = vector * 3 * np.sqrt(length)
    draw_vector(pca.mean_, pca.mean_ + v)
print(pca.components_)
print(pca.explained_variance_)

# Dimensionsredutkion
# Daten mit höchsten Varianz werden erhalten
pca = PCA(n_components=1)
pca.fit(X)
X_pca = pca.transform(X)
print('Ursprüngliche Shape: ', X.shape)
print('Transformierte Shape:', X_pca.shape)
X_new = pca.inverse_transform(X_pca)
plt.scatter(X_new[:, 0], X_new[:, 1], alpha=0.8)

plt.axis('equal')
plt.show()