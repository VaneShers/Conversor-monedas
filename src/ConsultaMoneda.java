import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

   public Moneda convierteMoneda(String monedabase, String monedatarget, int cantidad){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3b3988b8507fb4f17b0131e5/pair/" + monedabase + "/" + monedatarget + "/" + cantidad);

       HttpClient client = HttpClient.newHttpClient();
       HttpRequest request = HttpRequest.newBuilder()
               .uri(direccion)
               .build();
       try {
           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           return new Gson().fromJson(response.body(), Moneda.class);

       }catch (Exception e) {
           throw new RuntimeException("No se encontró la moneda");
       }
   }

}
