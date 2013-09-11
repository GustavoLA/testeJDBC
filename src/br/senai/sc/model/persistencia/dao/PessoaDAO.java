package br.senai.sc.model.persistencia.dao;

import br.senai.sc.model.negocio.Pessoa;
import java.util.List;

/**
 * Interface responsável pela declaração dos métodos relacionados a persistência
 * da classe Pessoa
 *
 * @author Gustavo L. Alves
 * @version 1.0 09/09/2013
 */
public interface PessoaDAO {

    boolean insert(Pessoa p);
    /*
     * Método responsável pela inserção de uma pessoa na base de dados
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */

    boolean update(Pessoa p);
    /*
     * Método responsável pela atualização de uma pessoa na base de dados
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */

    boolean delete(int id);
    /*
     * Método responsável pela remoção de uma pessoa da base de dados 
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */

    List<Pessoa> listAll();
    /*
     * Método responsável pela listagem de todas as pessoas cadastradas na base de dados 
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */

    Pessoa listById(int id);
    /*
     * Método reponsável por buscar uma pessoa na base de dados através de um id
     * @author Gustavo L. Alves
     * @versin 1.0 09/09/2013
     */
}
