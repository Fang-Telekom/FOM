import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.linear_model import LinearRegression

rng = np.random.RandomState(1)
X = 10 * rng.rand(100, 3)
y = 0.5 + np.dot(X, [1.5, -2., 1.])

model = LinearRegression(fit_intercept=True)
model.fit(X, y)


print("Steigerung: ", model.coef_)
print("Achsenabschnitt: ", model.intercept_)