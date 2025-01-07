import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()

from sklearn.linear_model import LinearRegression

# Erstellung von 50 zufälling Koordinatenpunkte X:0/10, Y = -5/15 (+/- 1 Zufall)
rng = np.random.RandomState(1)
x = 10 * rng.rand(50)
y = 2 * x - 5 + rng.randn(50)

# ChatGPT
# Fit Intercept - intercept represents the baseline value of y
# allows the model to shift up or down to better fit the data 
model = LinearRegression(fit_intercept=True)
# trainiere Modell, mit [x, newaxis=none/neutral] und y
model.fit(x[:, np.newaxis], y)

# Erstelle zwischen 0/10 1000 gleichmäßige Punkte
xfit = np.linspace(0, 10, 1000)
yfit = model.predict(xfit[:, np.newaxis])

plt.scatter(x, y)
# zeichne eine Line von 1 - 10 mit folgenden y werte
plt.plot(xfit, yfit)

# Anzeige von Intercept und Coeffizienten
print("Steigerung: ", model.coef_[0])
print("Achsenabschnitt: ", model.intercept_)

plt.show()