/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.repository;

import java.util.List;

/**
 *
 * @author Bane
 */
public interface Repository<T> {
     List<T> getAll();
     void add(T parametar) throws Exception;
}
