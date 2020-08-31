import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) {
		try {
			
			//buscar na pagina pricipal todos os link
            Document link = Jsoup.connect("https://www.americanas.com.br/categoria/celulares-e-smartphones/smartphone/samsung-galaxy/galaxy-s?ordenacao=topSelling").get();
			
            Document valor = Jsoup.connect("https://www.americanas.com.br/categoria/celulares-e-smartphones/smartphone/samsung-galaxy/galaxy-s?ordenacao=topSelling").get();
            
            //seleciona todas as div que tenha produto e extra somente os link
            Elements dados = link.getElementsByAttributeValue("class","Link-bwhjk3-2 iDkmyz TouchableA-p6nnfn-0 joVuoc");
            
            Elements valor1 = valor.getElementsByAttributeValue("class","PriceWrapper-bwhjk3-13 IjiIU ViewUI-sc-1ijittn-6 iXIDWU");
            
            
            String[] valores = new String[26];
            
            int h = 0;
			
			for(Element vl: valor1) {
				
				//lista as inf dos valores do celular de 0 a 2
				
				int x = 0;
				
				x = (x+1);
				
				h++;
				
				//System.out.println("valor celular "+(h++)+" :"+vl.text());
				
				//gurda todos os valores dentro de um array
				valores[h] = vl.text();
				
			}

            //contador 
            int g = 0;
            
            //volta o contador ao 1
            h = 1;
            //for que vai varrer todas as div e listar os link
            for(Element el: dados) {
            	
            	System.out.println("#####################################################################");
            	
            	//lista os links 
				System.out.println("celular "+(g++)+el.attr("href")); 
				
				//começa array[1] etc... e imprime os valores na ordem junto com link.
				System.out.println("valor  ::"+valores[h++]);
				
				//link da pagina principal para pegar os valores.
				
				
				//link que busca pelas info
                Document inf = Jsoup.connect("https://www.americanas.com.br"+el.attr("href")).get();
                
                //link que busca as info e tbm avaliaçao
                Document avl = Jsoup.connect("https://www.americanas.com.br"+el.attr("href")).get();
				
                //busca inf dentro das tabelas
				Elements tabela = inf.getElementsByTag("tr");
				
				 //para pegar a avaliaçao
				Elements avlmedia = avl.getElementsByAttributeValue("class", "Average-sc-1fg2071-4 eOvPfe TextUI-sc-12tokcy-0 kVUMyx");
				
				Elements avltotal = avl.getElementsByAttributeValue("class", "Quantity-sc-1fg2071-3 hWIROQ TextUI-sc-12tokcy-0 kVUMyx");
				
				
				
		
				
				
				
					for(Element al: tabela) {
						//lista as inf do celulares
						System.out.println("Inf :"+al.getElementsByClass("TextUI-sc-12tokcy-0").text());
					}
					
					
					for( Element avlm : avlmedia)
					{
						//busca a media das avaliaçao
						System.out.println("Avaliaçao media : " + avlm.text());  
					}
					
					for( Element avlt : avltotal)
					{
					//busca total de pessoas que avaliou
						System.out.println("Avaliaçao total : " + avlt.text());
						
					}
					
					
            }
            
			
			System.out.println("##########################################################################################################################################");
            
         
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
