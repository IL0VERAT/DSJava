library(factoextra)

iris
#iris.labels
iris.labels = iris$Species
table(iris.labels)
iris_data <- iris[1:4]

# Scale the data to keep distance metrics unweighted
iris_data_scale <- scale(iris_data)
#Distance; built into factoextra
iris_data <- dist(iris_data_scale)

# Calculate how many clusters you need
# Within Sum Squares
fviz_nbclust(iris_data_scale, kmeans, method = "wss") +
  labs(subtitle = "Elbow method")

# Kmeans
km.out <- kmeans(iris_data_scale, centers =3, nstart = 100)
print(km.out)

# Visualize the clustering algorithm results
km.clusters <- km.out$cluster
rownames(iris_data_scale) <- paste(iris$Species, 1:dim(iris)[1], sep = "_")
fviz_cluster(list(data=iris_data_scale, cluster = km.clusters))
table(km.clusters, iris$Species)

