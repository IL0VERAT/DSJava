library(ggplot2)

# fuel economy data from 1999 to 2008, for 38 popular models of cars
# engine displacement (size) is depicted on the x-axis
# fuel efficiency is depicted on the y-axis
ggplot(data = mpg,
       aes(x = displ, y = hwy)) +
  geom_point()


