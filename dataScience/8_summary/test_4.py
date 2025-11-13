import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns; sns.set_theme()
from sklearn.datasets import make_blobs
#unsupervisierte Lerner, Clustering, Klassifikator
# svm arbeitet sehr genügsam
from sklearn.svm import svm

X = [[0,0], [1, 1], [1,0], [0, 1]]
y = [0, 1, 0, 1]
#sv begrenzen, wird durch die Maschine bestimmt, müssen in den Daten sein
# Randhärte - Hyperparamter - wird nicht gezeigt
clf = svm.SVC(kernel="linear")
clf.fit(X, y)