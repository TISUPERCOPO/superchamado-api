package com.supercopo.chamado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.reactive.function.client.WebClient;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class SuperchamadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperchamadoApplication.class, args);
	}
	
	
	 @Bean
		public WebClient webClientcnpj(WebClient.Builder builder) {
			return builder
				.baseUrl("https://brasilapi.com.br/api/cnpj/v1/")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		}
	 
//	 
//	 @Bean
//		public WebClient webpedidos(WebClient.Builder builder) {
//			return builder
//				.baseUrl("http://192.168.88.251/One/pages/venda/pedidoVendaList/pedidos")
//				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//				.build();
//		}
}
