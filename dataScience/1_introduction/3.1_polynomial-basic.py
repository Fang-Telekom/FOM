import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.preprocessing import PolynomialFeatures

# Polynomiales Modell: Linearer Fit für nichtlineare Trainingsdaten
# PS: Polynom Vielfachen von Potenzen
x = np.array([2, 3, 4])
poly = PolynomialFeatures(3, include_bias=False)

print(poly.fit_transform(x[:, None]))