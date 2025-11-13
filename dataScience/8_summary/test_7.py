import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

# Gauß’sche Mixture-Modell (GMM)
# Dichteschätzung: Auf Cluster mit nichtlinearen Grenzen angewandt

from sklearn.mixture import gaussian_kde

data = np.random.normal(0, 1, 1000)
kde = gaussian_kde(data)