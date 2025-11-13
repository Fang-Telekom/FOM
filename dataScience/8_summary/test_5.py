import numpy as np
from sklearn.decomposition import PCA

X = np.array([[1, 2], [3, 4]])
# wenn n=1 -> 2 Komponente
pca = PCA(n_components=1)
x_pca = pca.fit_transform(X)
# transformiert in ein neuen 1 Dimensionale Raum

# Linear oder nicht lInerare D-Reduktion
# Linear

# Was geht hier?
# Soll Varianz(=Streung) erklären
# quadrierte Abweichung

# Sind keine empirische Daten; sind neue Daten

