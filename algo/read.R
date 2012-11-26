library(gbm)

iter <- 500

train <- read.table("/media/2A306A0F3069E275/study/intmat2012/vars_train1.txt", sep = " ")
model <- gbm(V1~., data=train, distribution="gaussian", n.trees=iter, shrinkage=0.5,
             interaction.depth=4, n.minobsinnode=10)
test <-  read.table("/media/2A306A0F3069E275/study/intmat2012/vars_test1.txt", sep = " ");
ttest <- train[,];
pred <- predict.gbm(model, test, gbm.perf(model, method = "OOB"));
sort.indexes <- sort.int(pred, decreasing = TRUE, index.return = TRUE)$ix;
test.sessions <-  read.table("/media/2A306A0F3069E275/study/intmat2012/test_sessions.txt");
write.table(test.sessions$V1[sort.indexes], "/media/2A306A0F3069E275/study/intmat2012/output.txt", col.names= FALSE, row.names = FALSE);
