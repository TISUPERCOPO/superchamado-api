package com.supercopo.chamado;

import org.mindrot.jbcrypt.BCrypt;


public class PasswordGenerator {

    public static void main(String[] args) {
        String senha = "user123"; // Sua senha original

        // Gerar hash da senha
        String senhaCriptografada = gerarSenhaCriptografada(senha);

        // Exibir senha original e senha criptografada
        System.out.println("Senha Original: " + senha);
        System.out.println("Senha Criptografada: " + senhaCriptografada);
    }

    // Método para gerar a senha criptografada
    public static String gerarSenhaCriptografada(String senha) {
        // Geração do salt (valor aleatório)
        String salt = BCrypt.gensalt();

        // Geração do hash da senha usando BCrypt
        String senhaCriptografada = BCrypt.hashpw(senha, salt);

        return senhaCriptografada;
    }
}
