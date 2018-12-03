package lab3.interfaces;

public interface CrudRepository<E>  {
    E findOne(Long id);
    Iterable<E> findAll();
    E save(E entity);
    E delete(Long id);
    E update(E entity);
}
