import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import com.google.gson.Gson;


public class Main {

    public static void main(String[] args) {
        try {
            URI uri = new URI("https", "dolarapi.com", "/v1/dolares/bolsa", null);
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if(responseCode == 200)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ( (line = reader.readLine()) != null){
                    response.append(line);
                }

                reader.close();

                System.out.println("Respuesta de la Api: " + response.toString());

                connection.disconnect();

                // Usamos Gson para deserializar el JSON en la clase Dolar
                Gson gson = new Gson();
                Dolar dolar = gson.fromJson(response.toString(), Dolar.class);

                // Imprimir los valores deserializados
                System.out.println("Compra: " + dolar.getCompra());
                System.out.println("Venta: " + dolar.getVenta());
                System.out.println("Moneda: " + dolar.getMoneda());
                System.out.println("Nombre: " + dolar.getNombre());
                System.out.println("Fecha de Actualización: " + dolar.getFechaAct());

            }else{
                throw new RuntimeException("Error al conectarnos a la API code: " +responseCode);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error en la coneccion", e);
        }
    }
}