import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.metrics import pairwise_distances
from sklearn.manifold import MDS
# MDS -> kein Lerner

np.random.seed(42)
data = np.random.randn(10, 3)

# 3 Dimensional, euklidische Distanz
# Distanz Matrix, kein Vektor
distance = pairwise_distances(data)

mds = MDS(n_components=2)
# Einbettung in eine 2 Dimensionale Raum
# Skaliert die distanz Matrix wieder hoch
new_data = mds.fit_transform(distance)