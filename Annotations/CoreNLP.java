import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class CoreNLP {

    public static void main(String[] args) throws IOException {

    	File fl;
        String s1,s="A";
        int c=0;
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");  // Set the properties required for annotation
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        CoreDocument doc;
        
        File dir = new File("/Users/farhan/Context/demo");    // Directory where files are taken for annotation
        

        PrintWriter outFile= new PrintWriter("/Users/farhan/Downloads/Context/annotatedNew/An43.txt");
       
        
        if(dir.exists())
        {
            int i=0;
            for (File file : dir.listFiles())
            {                                        
                fl=file.getAbsoluteFile();    //Reads each file one by one
                
                s1=FileUtils.readFileToString(fl, StandardCharsets.UTF_8);
                
                //doc = new CoreDocument(s1);
        
        Annotation document = new Annotation(s1);
        
        pipeline.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        try {
        for (CoreMap sentence : sentences) {
          
       
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) 
            {
                
                String word = token.get(CoreAnnotations.TextAnnotation.class);     //Get each token
                
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);    // Get POS Annotation
                
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);   // Get Name Entities
                
               
                s= word+"\t"+pos+"\t"+ne;   // Format of our Annotated Data
                System.out.println(s);
               outFile.println(s);  // Print each line to the annotated file
            }
        }
        }
        catch(NullPointerException Ne)
        {
        	continue;
        }
        //System.out.println("==NEXT FILE==");  
        c++;
        }
        }
        System.out.println("Bye");
        System.out.println(c);
    }
    
}


