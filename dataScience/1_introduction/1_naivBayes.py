import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.datasets import make_blobs
from sklearn.naive_bayes import GaussianNB

# Erstellung von 100 Datenpunkte mit 2 Feature (x, y koordinate hier)
# 2 Zentren/Zustände, Reproduzierbare Zufall(2) und erhöhte Standardabweichung (1.5)
# X = Koordinate, y = Zugehörigkeit
X, y = make_blobs(100, 2, centers=2, random_state=2, cluster_std=1.5)

# Erstellung vom Model, und Trainieren auf den Daten
model = GaussianNB()
model.fit(X, y)

# Zufallsgenerator, reproduzierbar mit Status 0
rng = np.random.RandomState(0)

# Erstellung von 2000 Koordinaten (x / y) in dem Bereich X: -6/8 Y:-14/4
Xnew = [-6, -14] + [14, 18] * rng.rand(2000, 2)
# Bestimmung ihrer Zugehörigkeit
ynew = model.predict(Xnew)

# Zeichnung der 100 Datenpunkten, Zugehörigkeit wird in Red oder Blue gezeigt
plt.scatter(X[:, 0], X[:, 1], c=y, s=50, cmap="RdBu")
#Speicherung der Koordinate Axen
lim = plt.axis()
# Zeichnen der 2000 Punkte in geringere Stärke (alpha=0.1)
plt.scatter(Xnew[:, 0], Xnew[:, 1], c=ynew, s=20, cmap="RdBu", alpha=0.1)
# Fixierung der vorherige Koordinaten Axen
plt.axis(lim)

# Zeige es
plt.show()