import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.linear_model import LinearRegression

# Wandelt Reihen Vektor in Spalten Vektor um
x = np.array([1, 2, 3, 4, 5]).reshape(-1, 1)
y = np.array([6, 7, 8, 9, 10])

model = LinearRegression()
model.fit(x, y)

y_pred = model.predict(x)
