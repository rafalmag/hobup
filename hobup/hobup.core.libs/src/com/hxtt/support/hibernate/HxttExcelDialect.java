package com.hxtt.support.hibernate;

import java.sql.Types;

/**
 * An SQL dialect for HXTT Excel.
 */
public class HxttExcelDialect extends HxttDialect {

	public HxttExcelDialect() {
		super();
		// complete map
		registerColumnType(Types.BIT, "boolean");
		registerColumnType(Types.CHAR, "char(l)");
		registerColumnType(Types.VARCHAR, "varchar($l)");
		// registerColumnType(Types.VARCHAR, 255, "varchar($l)");
		registerColumnType(Types.LONGVARCHAR, "longvarchar");
		registerColumnType(Types.NUMERIC, "numeric($p,$s)");
		registerColumnType(Types.BOOLEAN, "boolean");
		registerColumnType(Types.BIGINT, "bigint");
		registerColumnType(Types.SMALLINT, "numeric(5,0)"); // HXTT Excel DON'T
															// SUPPORT SMALLINT
		registerColumnType(Types.TINYINT, "numeric(3,0)"); // HXTT Excel DON'T
															// SUPPORT TINYINT
		registerColumnType(Types.INTEGER, "integer");
		registerColumnType(Types.REAL, "real");
		registerColumnType(Types.FLOAT, "float"); // HXTT Excel DON'T SUPPORT
													// FLOAT ,it will be a
													// double type
		registerColumnType(Types.DOUBLE, "double");
		registerColumnType(Types.BINARY, "binary");
		registerColumnType(Types.VARBINARY, "varbinary");
		registerColumnType(Types.LONGVARBINARY, "longvarbinary");

		registerColumnType(Types.DATE, "date");
		registerColumnType(Types.TIME, "time");
		registerColumnType(Types.TIMESTAMP, "timestamp");
		registerColumnType(Types.BLOB, "blob"); // BLOB COLUMN WILL CHANGE TO
												// JAVA_OBJECT TYPE COLUMN
		registerColumnType(Types.CLOB, "clob"); // CLOB COLUMN WILL CHANGE TO
												// LONGVARCHAR TYPE COLUMN
		// registerColumnType(Types.OTHER, "currency");
		// registerColumnType( Types.OTHER, "graphics" );
		// registerColumnType(Types.OTHER, "ole");
		registerColumnType(Types.JAVA_OBJECT, "java_object");

	}

	/**
	 * Apply s limit clause to the query.
	 * <p/>
	 * Typically dialects utilize {@link #supportsVariableLimit() variable}
	 * limit caluses when they support limits. Thus, when building the select
	 * command we do not actually need to know the limit or the offest since we
	 * will just be using placeholders.
	 * <p/>
	 * Here we do still pass along whether or not an offset was specified so
	 * that dialects not supporting offsets can generate proper exceptions. In
	 * general, dialects will override one or the other of this method and
	 * {@link #getLimitString(String, int, int)}.
	 * 
	 * @param query
	 *            The query to which to apply the limit.
	 * @param hasOffset
	 *            Is the query requesting an offset?
	 * @return the modified SQL
	 */
	@Override
	public String getLimitString(String sql, boolean hasOffset) {

		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		if (hasOffset) {
			pagingSelect
					.append("select * from ( select row_.*, RECNO() rownum_ from ( ");
		}
		else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (hasOffset) {
			pagingSelect.append(" ) row_ where RECNO() = ?) where rownum_ > ?");
		}
		else {
			pagingSelect.append(" ) where RECNO() = ?");
		}

		if (isForUpdate)
			pagingSelect.append(" for update");

		return pagingSelect.toString();
	}

	/**
	 * Does this dialect support identity column key generation?
	 * 
	 * @return True if IDENTITY columns are supported; false otherwise.
	 */
	@Override
	public boolean supportsIdentityColumns() {
		return false;
	}

	/**
	 * Whether this dialect have an Identity clause added to the data type or a
	 * completely seperate identity data type
	 * 
	 * @return boolean
	 */
	@Override
	public boolean hasDataTypeInIdentityColumn() {
		return false;
	}

}