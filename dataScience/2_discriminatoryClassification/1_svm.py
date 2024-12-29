import numpy as np
import matplotlib.pyplot as plt
from scipy import stats

# use seaborn plotting defaults
import seaborn as sns; sns.set_theme()
from sklearn.datasets import make_blobs
from sklearn.svm import SVC # SV-Klassifikator
from ipywidgets import interact, fixed

# SVM
# Support Vector Machine

def plot_svc_decision(model, ax=None, plot_support=True):
    if ax is None:
        ax = plt.gca()
    xlim = ax.get_xlim()
    ylim = ax.get_ylim()

    # create grid to evaluate model
    x = np.linspace(xlim[0], xlim[1], 30)
    y = np.linspace(ylim[0], ylim[1], 30)
    Y, X = np.meshgrid(y, x)
    xy = np.vstack([X.ravel(), Y.ravel()]).T
    P = model.decision_function(xy).reshape(X.shape)
    
    # plot decision boundary and margins
    ax.contour(X, Y, P, colors='k',
               levels=[-1, 0, 1], alpha=0.5,
               linestyles=['--', '-', '--'])
    
    # plot support vectors
    if plot_support:
        ax.scatter(model.support_vectors_[:, 0],
                   model.support_vectors_[:, 1],
                   s=300, linewidth=1, facecolors='none')
    ax.set_xlim(xlim)
    ax.set_ylim(ylim)

def plot_svm(N=10, ax=None):
    X, y = make_blobs(n_samples=200, centers=2, random_state=0, cluster_std=0.6)
    X = X[:N]
    y = y[:N]
    # C legt die Härte des Margins fest (sehr große Wert)
    # Gamme gibt die Größe des Kernels der radialen Basisfunktion an
    model = SVC(kernel="linear", C=1E10)
    model.fit(X, y)

    ax = ax or plt.gca()
    ax.scatter(X[:, 0], X[:, 1], c=y, s=50, cmap="autumn")
    ax.set_xlim(-1, 4)
    ax.set_ylim(-1, 6)
    plot_svc_decision(model, ax)

fig, ax = plt.subplots(1, 2, figsize=(16,6))
# left -> 0 moves edge closer to the left edge 
# right -> 1 moves edge closer to the right edge | -> 0 moves further away from the right edge
fig.subplots_adjust(left=0.0625, right=0.95, wspace=0.1)

# Merkmal des SVM-Modells anzuzeigen
# interact(plot_svm, N=[10, 200], ax=fixed(None))
for axi, N in zip (ax, [60, 120]):
    plot_svm(N, axi)
    axi.set_title("N = {0}".format(N))


plt.show()