package entities;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Calendar;

public class exceptionCheck
{

    public static boolean isValidEmail(String email)
    {
        return email.contains("@");
    }

    public static boolean isValidCPF(String cpf)
    {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        /*
        * "\\d" representa um digito numerico de 1 a 9
        * "\\." faz o '.' ser interpretado como um ponto literal, e não um caractere especial
        * "\\d{n}" indica que o elemento anterior (\\d) deve acontecer 'n' vezes
        */
    }

    public static boolean isValidPassword(String password) {

        if (password.length() < 8 || password.length() > 12)
        {
            return false;
        }

        // Se não tiver nenhuma letra maiuscula ou minuscula ou número
        if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*\\d.*"))
        {
            // ".*" no final e no inicio permite que qualquer sequência de caracteres apareça antes ou depois do caractere maiúsculo (A-Z)
            return false;
        }

        // Se tiver algum caractere acentuado
        if (password.matches(".*[À-ú].*"))
        {
            return false;
        }

        // Se tiver pelo menos um caractere especial, é válida. (retorna True)
        return password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    public static boolean isValidDate(int year, int month, int day)
    {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31)
        {
            return false;
        }

        if (month == 2)
        {
            if (day > 29)
            {
                return false;
            }

            if (day == 29)
            { // Verifica ano bissexto: deve ser divisível por 4 e não divisível por 100, ou divisível por 400
                return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) // Meses com 30 dias
        {
            return day <= 30;
        }

        return true;
    }

    public static boolean isValidCode(String vendaCode)
    {
        return vendaCode.matches("\\d{6}");
    }
}
