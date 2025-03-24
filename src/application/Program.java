package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: Seller Find By Id ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println();

		System.out.println("=== Test 2: Seller Find By Department ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== Test 3: Seller findAll===");

		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== Test 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Greg Grow", "greg@gmail.com", new
		Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new seller! new id: " + newSeller.getId());

		System.out.println();
		System.out.println("=== test 5: Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Seller Updated!");

		System.out.println("");
		System.out.println("=== Test 6: Seller Delete ===");
		sellerDao.deleteById(8);

		System.out.println("Seller deleted");

	}

}
