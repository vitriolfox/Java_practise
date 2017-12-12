import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class SPAMFilterMain {

    public static void display(File emlFile) throws Exception{
        Properties props = System.getProperties();
        props.put("mail.host", "smtp.dummydomain.com");
        props.put("mail.transport.protocol", "smtp");

        Session mailSession = Session.getDefaultInstance(props, null);
        InputStream source = new FileInputStream(emlFile);
        MimeMessage message = new MimeMessage(mailSession, source);


        System.out.println("Subject : " + message.getSubject());
        System.out.println("From : " + message.getFrom()[0]);
        System.out.println("--------------");
        System.out.println("Body : " +  message.getContent());
    }

    public static void main(String[] args) throws Exception {
        File trainingFileRootPathDirectory = new File("./data/CSDMC2010_SPAM/CSDMC2010_SPAM/TRAINING");

        if (trainingFileRootPathDirectory.exists() && trainingFileRootPathDirectory.isDirectory()) {
            File[] files = trainingFileRootPathDirectory.listFiles();

            for (File file : files) {
                    if (file.getName().endsWith(".eml")){
                        //System.out.println(file);
                        display(file);

                } else {
                        System.out.println(file + " Nem .eml!");
                    }
            }
        }
    }
}
