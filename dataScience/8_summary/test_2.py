from sklearn.naive_bayes import GaussianNB
# stochastische unabhängigkeit
# Gauß'sche Normalverteilung
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score

#iris datensatz 4
# jede Kombination
iris = load_iris()
X = iris.data # gro? -> min 2d array
y =iris.target # klein -> vektor

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

clf = GaussianNB()
clf.fit(X_train, y_train)

y_pred = clf.predict(X_test)

accuracy = accuracy_score(y_test, y_pred)