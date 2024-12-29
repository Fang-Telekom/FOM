import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.metrics import pairwise_distances
# MDS
# Multidimensionale Skalierung

from matplotlib.image import imread
from sklearn.manifold import MDS
from mpl_toolkits import mplot3d

def make_hello(N=1000, rseed=42):
    # HELLO-Diagramm erstellen und als PNG-Datei speichern
    fig, ax = plt.subplots(figsize=(4, 1))
    fig.subplots_adjust(left=0, right=1, bottom=0, top=1)
    ax.axis('off')
    ax.text(0.5, 0.4, 'HELLO', va='center', ha='center', weight='bold', size=85)
    fig.savefig('hello.png')
    plt.close(fig)
    
    # PNG-Datei öffnen und zufällige Punkte zeichnen   
    data = imread('hello.png')[::-1, :, 0].T
    rng = np.random.RandomState(rseed)
    X = rng.rand(4 * N, 2)
    i, j = (X * data.shape).astype(int).T
    mask = (data[i, j] < 1)
    X = X[mask]
    X[:, 0] *= (data.shape[0] / data.shape[1])
    X = X[:N]
    return X[np.argsort(X[:, 0])]

def rotate(X, angle):
    theta = np.deg2rad(angle)
    R = [[np.cos(theta), np.sin(theta)],
         [-np.sin(theta), np.cos(theta)]]
    return np.dot(X, R)

def random_projection(X, dimension=3, rseed=42):
    assert dimension >= X.shape[1]
    rng = np.random.RandomState(rseed)
    C = rng.randn(dimension, dimension)
    e, V = np.linalg.eigh(np.dot(C, C.T))
    return np.dot(X, V[:X.shape[1]])

model = MDS(n_components=2, dissimilarity="precomputed", random_state=1)

X = make_hello(1000)
colorize = dict(c=X[:, 0], cmap=plt.get_cmap('rainbow', 5))
X = rotate(X, 20) + 5

X = random_projection(X, 3)

ax = plt.axes(projection='3d')
ax.scatter3D(X[:, 0], X[:, 1], X[:, 2], **colorize)
ax.view_init(azim=70, elev=50)

plt.show()

model = MDS(n_components=2, random_state=1)
out = model.fit_transform(X)
plt.scatter(out[:, 0], out[:, 1], **colorize)
plt.axis('equal')

plt.show()



