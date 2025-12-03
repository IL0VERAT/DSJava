library(keyATM)
library(quanteda)
library(readtext)
library(magrittr)

# Read text files
raw_docs <- readtext("/Users/miloscomputer/Downloads/EffectOnFuture.txt",
  encoding = "UTF-8"
)

# Preprocessing with quanteda and create a dfm object
key_corpus <- corpus(raw_docs, text_field = "text")

data_tokens <- tokens(key_corpus,
  remove_numbers = TRUE,
  remove_punct = TRUE,
  remove_symbols = TRUE,
  remove_separators = TRUE,
  remove_url = TRUE
) |>
  tokens_tolower() |>
  tokens_remove(
    c(
      stopwords("english"),
      "just", "for", "the", "also", "like", "may", "go",
      "your", "upon", "with", "by", "can", "it's", "i'd"
    )
  )|>
  tokens_select(min_nchar = 3)

data_dfm <- dfm(data_tokens) 

keyATM_docs <- keyATM_read(texts = data_dfm)
summary(keyATM_docs)

keywords <- list(
  Understanding  = c("knowledge", "understanding", "skills"),
  Career         = c("degree", "job"),
  Grades         = c("classes", "grades", "studies")
)

set.seed(225) # set the seed before spliting the dfm
docs_withSplit <- keyATM_read(
  texts = data_dfm,
  split = 0.3
)

out <- weightedLDA(
  docs              = docs_withSplit$W_split, # 30% of the corpus, meaning file
  number_of_topics  = 10, # the number of potential themes in corpus
  model             = "base",
  options           = list(seed = 250)
)
top_words(out)

out <- keyATM(
  docs              = docs_withSplit, # 70% of the corpus
  no_keyword_topics = 3, # number of topics without keywords
  keywords          = keywords,
  model             = "base",
  options           = list(seed = 250)
)

saveRDS(out, file = "SAVENAME.rds")
out <- readRDS(file = "SAVENAME.rds")
top_words(out)

fig_modelfit <- plot_modelfit(out)
fig_modelfit
