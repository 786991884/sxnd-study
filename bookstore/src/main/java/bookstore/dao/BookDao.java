package bookstore.dao;

import java.util.Collection;
import java.util.List;

import bookstore.domain.Book;
import bookstore.domain.ShoppingCartItem;
import bookstore.web.CriteriaBook;
import bookstore.web.Page;

public interface BookDao {
	/**
	 * 根据id获取指定的Book对象
	 *
	 * @param id
	 * @return
	 */
	Book getBook(int id);

	/**
	 * 根据传入的CriteraBook对象返回对应的page对象
	 *
	 * @param cb
	 * @return
	 */
	Page<Book> getPage(CriteriaBook cb);

	/**
	 * 根据传入的CriteriaBook对象返回其对应的记录数
	 *
	 * @param cb
	 * @return
	 */
	long getTotalBookNumber(CriteriaBook cb);

	/**
	 * 根据传入的CriteriaBook和pageSize返回当前页对应的list
	 *
	 * @param cb
	 * @param pageSize
	 * @return
	 */
	List<Book> getPageList(CriteriaBook cb, int pageSize);

	/**
	 * 返回指定id的book的storeNumber字段的值
	 *
	 * @param id
	 * @return
	 */
	int getStoreNumber(Integer id);

	/**
	 * 根据传入的ShoppingCartItem的集合， 批量更新books数据表的storenumber和salesnumber字段的值
	 *
	 * @param items
	 */
	void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);
}
