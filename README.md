------------------------------
HOW TO USE ???
------------------------------

1) Firstly, familiarise with the scraped context of each class of entity present in the /Users/UserName/MajorProject/Codes/Content_Extraction folder.

2) Thereafter, run the CoreNLP.java file present in the Annotations folder.

3) After running the above piece of code, a new text file will be created which will have the annotated named entity class of each token parsed in each sentence of the context file.

4) Once, the annotation file is generated using Standford NER , the cleaning of the data is important to reduce the occurrence of mismatch of tagged entities.

5) After this, we shall divide the annotation corpus which is present in the folder Annotations as "Annotated_Corpus.tsv" . Now divide the corpus into training and test set with a ratio of 7:3 respectively.

6) Make sure that the test set data is completely hidden from training set data to avoid overfitting.

7) Use the dependencies in the Dependencies folder keeping the training and test data in the same folder.

8) Make sure the Standford Classifier "english.conll.4class.distsim.crf.ser.gz" is present along with "standford-ner.jar" and "prop.txt".

9) Set your Java Homepath using the following command:
export JAVA_HOME=/Library/Java/Home


10) Once everything is in place run the following commands in Command Prompt/Terminal :

   To train and create your own model :

   java -cp stanford-ner.jar edu.stanford.nlp.ie.crf.CRFClassifier -prop prop.txt

11) After this, or own classifier named "dummy-ner-model-hindi.ser.gz" will be created.

12) Now run this classifier on the test data set to generate precision, recall and F1 scores using the following command to be run in Command 	       Prompt/Terminal :

   To test your data using newly created model classifier:

   java -cp  stanford-ner.jar edu.stanford.nlp.ie.crf.CRFClassifier -loadClassifier dummy-ner-model-hindi.ser.gz -testFile Testing.tsv

13) Now a set of precision, recall and F1 scores will be shown on the screen with respect to different class of entities i.e. Person, Organization, Location and Misc.



>>>This project "Context Based Indian NER From Wikipedia" has been carried out under the supervision of Mr. Mohammad Zeeshan Ansari, Assistant Professor, Dept. Of Computer Engineering.

-----------
Made By :
-----------

Md Farhan ul Haque
15BCS0022

B.Tech, 4th Year, Dept. of Computer Engineering, Jamia Millia Islamia, New Delhi -25.
