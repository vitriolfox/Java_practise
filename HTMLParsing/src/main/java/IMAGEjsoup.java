import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class IMAGEjsoup {


        public static void main( String[] args ) throws IOException {

            String url = args[0];
            Document doc = Jsoup.connect(url).get();
            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {
                System.out.println("src : " + image.attr("src"));
                System.out.println("height : " + image.attr("height"));
                System.out.println("width : " + image.attr("width"));
                System.out.println("alt : " + image.attr("alt"));
            }

        }
    }


