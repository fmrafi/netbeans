/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoollibrary1;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import schoollibrary1.exceptions.NonexistentEntityException;

/**
 *
 * @author Meraj Ali
 */
public class AuthorsJpaController implements Serializable {

    public AuthorsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Authors authors) {
        if (authors.getBooksCollection() == null) {
            authors.setBooksCollection(new ArrayList<Books>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Books> attachedBooksCollection = new ArrayList<Books>();
            for (Books booksCollectionBooksToAttach : authors.getBooksCollection()) {
                booksCollectionBooksToAttach = em.getReference(booksCollectionBooksToAttach.getClass(), booksCollectionBooksToAttach.getId());
                attachedBooksCollection.add(booksCollectionBooksToAttach);
            }
            authors.setBooksCollection(attachedBooksCollection);
            em.persist(authors);
            for (Books booksCollectionBooks : authors.getBooksCollection()) {
                Authors oldAuthorOfBooksCollectionBooks = booksCollectionBooks.getAuthor();
                booksCollectionBooks.setAuthor(authors);
                booksCollectionBooks = em.merge(booksCollectionBooks);
                if (oldAuthorOfBooksCollectionBooks != null) {
                    oldAuthorOfBooksCollectionBooks.getBooksCollection().remove(booksCollectionBooks);
                    oldAuthorOfBooksCollectionBooks = em.merge(oldAuthorOfBooksCollectionBooks);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Authors authors) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Authors persistentAuthors = em.find(Authors.class, authors.getId());
            Collection<Books> booksCollectionOld = persistentAuthors.getBooksCollection();
            Collection<Books> booksCollectionNew = authors.getBooksCollection();
            Collection<Books> attachedBooksCollectionNew = new ArrayList<Books>();
            for (Books booksCollectionNewBooksToAttach : booksCollectionNew) {
                booksCollectionNewBooksToAttach = em.getReference(booksCollectionNewBooksToAttach.getClass(), booksCollectionNewBooksToAttach.getId());
                attachedBooksCollectionNew.add(booksCollectionNewBooksToAttach);
            }
            booksCollectionNew = attachedBooksCollectionNew;
            authors.setBooksCollection(booksCollectionNew);
            authors = em.merge(authors);
            for (Books booksCollectionOldBooks : booksCollectionOld) {
                if (!booksCollectionNew.contains(booksCollectionOldBooks)) {
                    booksCollectionOldBooks.setAuthor(null);
                    booksCollectionOldBooks = em.merge(booksCollectionOldBooks);
                }
            }
            for (Books booksCollectionNewBooks : booksCollectionNew) {
                if (!booksCollectionOld.contains(booksCollectionNewBooks)) {
                    Authors oldAuthorOfBooksCollectionNewBooks = booksCollectionNewBooks.getAuthor();
                    booksCollectionNewBooks.setAuthor(authors);
                    booksCollectionNewBooks = em.merge(booksCollectionNewBooks);
                    if (oldAuthorOfBooksCollectionNewBooks != null && !oldAuthorOfBooksCollectionNewBooks.equals(authors)) {
                        oldAuthorOfBooksCollectionNewBooks.getBooksCollection().remove(booksCollectionNewBooks);
                        oldAuthorOfBooksCollectionNewBooks = em.merge(oldAuthorOfBooksCollectionNewBooks);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = authors.getId();
                if (findAuthors(id) == null) {
                    throw new NonexistentEntityException("The authors with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Authors authors;
            try {
                authors = em.getReference(Authors.class, id);
                authors.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The authors with id " + id + " no longer exists.", enfe);
            }
            Collection<Books> booksCollection = authors.getBooksCollection();
            for (Books booksCollectionBooks : booksCollection) {
                booksCollectionBooks.setAuthor(null);
                booksCollectionBooks = em.merge(booksCollectionBooks);
            }
            em.remove(authors);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Authors> findAuthorsEntities() {
        return findAuthorsEntities(true, -1, -1);
    }

    public List<Authors> findAuthorsEntities(int maxResults, int firstResult) {
        return findAuthorsEntities(false, maxResults, firstResult);
    }

    private List<Authors> findAuthorsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Authors.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Authors findAuthors(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Authors.class, id);
        } finally {
            em.close();
        }
    }

    public int getAuthorsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Authors> rt = cq.from(Authors.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
