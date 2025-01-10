from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
import matplotlib.pyplot as plt

#Datensatz laden
iris = datasets.load_iris()
X = iris.data[:, :2] #nur erste beide merkmale
y = iris.target

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random=42)
C_values = [0.1, 1, 10]
models = []
for C in C_values:
	model = SVC(C=C, kernel='linear')
	model.fit(X_train, y_train)
	models.append(model)
	
plt.figure(figsize=(15, 5))
for i, model in enumerate(models):
	plt.subplot(1, 3, i + 1)
	plt.scatter(X_train[:,0], X_train[:,1], c=y_train, cmap='coolwarm', s=50)
	plt.scatter(model.support_vectors_[:, 0], models.support_vectors_[:, 1], facecolor='none', s=100)
	plt.title(f'SVC mit C={C_values[i]}')
plt.show()