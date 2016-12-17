package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jdbc07.ConnectionFactory;
import bank.entity.BankAccount;
import bank.entity.BankStatement;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	//
	public BankAccount newBankAccount(BankAccount ba) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);

			pstmt = conn
					.prepareStatement("insert into bankaccount(name,balance) values(?,?)");
			pstmt.setString(1, ba.getName());
			pstmt.setFloat(2, ba.getBalance());
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select last_insert_id()");
			rs = pstmt.executeQuery();
			rs.next();
			ba.setAccno(rs.getLong(1));

			pstmt = conn
					.prepareStatement("insert into bankstatement(action,txdate,amt,fromaccno) values(?,?,?,?)");
			pstmt.setString(1, "");
			Date date = new Date();
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			pstmt.setFloat(3, ba.getBalance());
			pstmt.setLong(4, ba.getAccno());
			pstmt.executeUpdate();

			conn.commit();
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(se);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return ba;
	}

	@Override
	public BankAccount deposit(BankAccount ba, float amt) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BankAccount bankAccount = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update bankaccount set balance=balance+? where accno=?");
			pstmt.setFloat(1, amt);
			pstmt.setLong(2, ba.getAccno());
			pstmt.executeUpdate();
			pstmt = conn
					.prepareStatement("insert into bankstatement(action,txdate,amt,fromaccno)values(?,?,?,?)");
			pstmt.setString(1, "");
			Date date = new Date();
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			pstmt.setFloat(3, amt);
			pstmt.setLong(4, ba.getAccno());
			pstmt.executeUpdate();
			pstmt = conn
					.prepareStatement("select * from bankaccount where accno=?");
			pstmt.setLong(1, ba.getAccno());
			rs = pstmt.executeQuery();
			bankAccount = new BankAccount();
			rs.next();
			bankAccount.setAccno(rs.getLong(1));
			bankAccount.setName(rs.getString(2));
			bankAccount.setBalance(rs.getFloat(3));
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return bankAccount;
	}

	@Override
	public BankAccount withdraw(BankAccount ba, float amt) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BankAccount bankaccount = null;
		try {
			conn.setAutoCommit(false);

			pstmt = conn
					.prepareStatement("update bankaccount set balance=balance-? where accno=?");
			pstmt.setFloat(1, amt);
			pstmt.setLong(2, ba.getAccno());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into bankstatement(action,txdate,amt,fromaccno) values(?,?,?,?)");
			pstmt.setString(1, "");
			Date date = new Date();
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			pstmt.setFloat(3, amt);
			pstmt.setLong(4, ba.getAccno());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("select * from bankaccount where accno=?");
			pstmt.setLong(1, ba.getAccno());
			rs = pstmt.executeQuery();
			bankaccount = new BankAccount();
			rs.next();
			bankaccount.setAccno(rs.getLong(1));
			bankaccount.setName(rs.getString(2));
			bankaccount.setBalance(rs.getFloat(3));

			conn.commit();
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(se);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return bankaccount;
	}

	@Override
	public BankAccount transfer(BankAccount from, BankAccount to, float amt) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BankAccount bankaccount = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update bankaccount set balance=balance-? where accno=?");
			pstmt.setFloat(1, amt);
			pstmt.setLong(2, from.getAccno());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("update bankaccount set balance=balance+? where accno=?");
			pstmt.setFloat(1, amt);
			pstmt.setLong(2, to.getAccno());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into bankstatement(action,txdate,amt,fromaccno,toaccno) values(?,?,?,?,?)");
			pstmt.setString(1, "");
			Date date = new Date();
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			pstmt.setFloat(3, amt);
			pstmt.setLong(4, from.getAccno());
			pstmt.setLong(5, to.getAccno());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("select * from bankaccount where accno=?");
			pstmt.setLong(1, from.getAccno());
			rs = pstmt.executeQuery();
			bankaccount = new BankAccount();
			rs.next();
			bankaccount.setAccno(rs.getLong(1));
			bankaccount.setName(rs.getString(2));
			bankaccount.setBalance(rs.getFloat(3));

			conn.commit();
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(se);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return bankaccount;
	}

	@Override
	public BankAccount findAccountByAccno(long accno) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BankAccount bank = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("select * from bankaccount where accno=?");
			pstmt.setFloat(1, accno);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return null;
			}
			rs.first();
			bank = new BankAccount();
			bank.setAccno(rs.getLong(1));
			bank.setName(rs.getString(2));
			bank.setBalance(rs.getFloat(3));
			pstmt = conn
					.prepareStatement("insert into bankstatement(action,txdate,amt,fromaccno) values(?,?,?,?)");
			pstmt.setString(1, "");
			Date date = new Date();
			pstmt.setDate(2, new java.sql.Date(date.getTime()));
			pstmt.setFloat(3, 0);
			pstmt.setLong(4, accno);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return bank;
	}

	@Override
	public Collection<BankAccount> getAllAccount() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Collection<BankAccount> list = null;
		BankAccount bankaccount = null;
		try {
			pstmt = conn.prepareStatement("select * from bankaccount");
			rs = pstmt.executeQuery();
			list = new ArrayList<BankAccount>();
			while (rs.next()) {
				bankaccount = new BankAccount();
				bankaccount.setAccno(rs.getLong(1));
				bankaccount.setName(rs.getString(2));
				bankaccount.setBalance(rs.getFloat(3));

				list.add(bankaccount);
			}
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(se);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return list;
	}

	@Override
	public Set<BankStatement> findStatementByAccno(long accno) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Set<BankStatement> bankSet = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("select * from bankstatement where fromaccno=?");
			pstmt.setLong(1, accno);
			rs = pstmt.executeQuery();
			if (rs != null) {
				bankSet = new HashSet<>();
				while (rs.next()) {
					BankStatement bank = new BankStatement();
					bank.setId(rs.getLong(1));
					bank.setAction(rs.getString(2));
					bank.setTxDate(rs.getDate(3));
					bank.setAmt(rs.getFloat(4));
					BankAccount fromaccount = new BankAccount();
					fromaccount.setAccno(rs.getLong(5));
					bank.setToaccount(fromaccount);
					BankAccount toaccount = new BankAccount();
					toaccount.setAccno(rs.getLong(6));
					bank.setToaccount(toaccount);
					bankSet.add(bank);
				}
				pstmt = conn
						.prepareStatement("insert into bankstatement(action,txdate,amt,fromaccno) values(?,?,?,?)");
				pstmt.setString(1, "");
				Date date = new Date();
				pstmt.setDate(2, new java.sql.Date(date.getTime()));
				pstmt.setFloat(3, 0);
				pstmt.setLong(4, accno);
				pstmt.executeUpdate();
				conn.commit();
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return bankSet;
	}
}
