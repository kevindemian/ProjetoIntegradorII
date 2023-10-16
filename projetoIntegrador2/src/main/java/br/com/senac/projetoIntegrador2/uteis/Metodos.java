/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.projetoIntegrador2.uteis;

import java.awt.Color;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author escre
 */
public class Metodos {

    //VALIDAÇÕES----------------------------------------------------------------------------------------------------
    public static boolean validaDataTxtField(JTextField txt) {

        String[] v = txt.getText().split("/");

        if (v[0].isBlank() || v[1].isBlank() || v[2].isBlank()) {

            return false;

        } else {

        int dia = Integer.parseInt(v[0]);
        int mes = Integer.parseInt(v[1]);
        int ano = Integer.parseInt(v[2]);
            boolean vDia = dia > 0 && dia <= 31;
            boolean vMes = mes > 0 && mes <= 12;
            boolean vAno = ano > 1900 && ano <= LocalDate.now().getYear();
            boolean valida = true;
            if (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11) {

                if (dia > 30) {
                    valida = false;
                }

            }

            if (mes == 2 && dia > 29) {
                valida = false;
            }

            return vDia && vMes && vAno && valida && txt.getText().matches("\\d{2}\\/\\d{2}\\/\\d{4}");
        }
    }

    public static boolean validaInt(String a) {

        return a.matches("\\d{1,}");

    }

    public static boolean validaValor(String a) {

        return a.matches("\\d+((.|,)\\d{0,2})?");
    }

    public static boolean validaCep(String a) {

        return a.matches("\\d{1,2}\\.?\\d{3}-?\\d{3}");
    }

    public static boolean validaPalavra(String a) {

        return a.matches("[A-Z|a-z]{1,}");

    }

    public static boolean validaTexto(String a) {

        return a.matches("^[[ ]|\\p{L}*\\p{Graph}]+$");
    }

    public static boolean validaTelefone(String a) {

        return a.matches("^(\\(?\\d{2}\\)?\\s?)?(\\d{4,5}\\-?\\d{4})$");
    }

    public static boolean validaEmail(String email) {

        return email.matches("\\w+@\\w+\\.\\w{2,3}\\.\\w{0,3}") || email.matches("\\w+@\\w+\\.\\w{2,3}");
    }

    public static boolean validaCPF(String cpf) {

        return cpf.matches("\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}");
    }

    public static boolean validaCNPJ(String cnpj) {

        return cnpj.matches("\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}\\-?\\d{2}");
    }

    public static boolean validaSite(String site) {

        return site.matches("(\\w{2,3}\\.)?\\w+\\.\\w{2,4}(\\.\\w{1,3})?");
    }

    public static void msgValidacao(boolean b, JTextField txt, String campo) {

        if (!txt.getText().isBlank() && !txt.getText().isEmpty()) {
            if (!b) {
                Metodos.criaBoxMsg("Atenção!!: " + campo + " digitado incorretamente.", "Erro em " + campo, 2);
                txt.setBackground(Color.red);
                txt.setText("");

            } else {
                txt.setBackground(Color.white);
            }
        }

    }

    // -------------------------------------------------------------------------------------------------------------------
    public static int getPosicao(JTable tabela) {

        int pos = tabela.getSelectedRow();

        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
        }

        return pos;
    }

    public static void limpaCampos(List<JTextField> txt) {

        for (JTextField texto : txt) {
            texto.setText("");
        }

    }

    public static boolean checkEmptyFields(List<JTextField> txt) {

        for (JTextField texto : txt) {
            if (texto.getText().isEmpty()) {

                Metodos.criaBoxMsg("Preencha todos os campos", "Campo vazio", 2);

                return true;
            }

        }
        return false;

    }

    public static int criaBoxEscolha(String[] botoes, String msg, String titulo) {
        String[] options = botoes;
        int editar = JOptionPane.showOptionDialog(
                null,
                msg, titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        return editar;
    }

    // 0-> ERRO, 1->INFORMAÇÃO, 2-> ATENÇÃO, 3-> PERGUNTA
    public static void criaBoxMsg(String msg, String title, int tipo) {

        JOptionPane.showMessageDialog(null, msg, title, tipo);

    }

    //METODOS DE TABELA ---------------------------------------------------------------------
    public int getPosicaoItemNaTabela(JTable tabela, String aviso) {

        int pos = tabela.getSelectedRow();

        if (pos == -1) {
            JOptionPane.showMessageDialog(null, aviso);
        }

        return pos;
    }

}
