package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Endereco;
import java.util.List;

/**
 * Interface responsável pela declaração dos métodos relacionados a persistência
 * da classe Endereço
 *
 * @author Gustavo L. Alves
 * @version 1.0 09/09/2013
 */
public interface EnderecoDAO {

    boolean insert(Endereco e);
    /*
     * Método responsável pela inserção de um endereço na base de dados
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */

    boolean update(Endereco e);
    /*
     * Método responsável pela atualização de um endereço na base de dados
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */

    boolean delete(int id);
    /*
     * Método responsável pela remoção de um endereço da base de dados 
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */

    List<Endereco> listAll();
    /*
     * Método responsável pela listagem de todos os endereços cadastrados na base de dados 
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */

    Endereco listById(int id);
    /*
     * Método reponsável por buscar um endereço na base de dados através de um id
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */
}
