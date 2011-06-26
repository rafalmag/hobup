package com.hxtt.support.hibernate;

import org.hibernate.MappingException;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.BooleanType;
import org.hibernate.type.ByteType;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimeType;
import org.hibernate.type.TimestampType;

//import org.hibernate.type.StandardBasicTypes;
/**
 * An common SQL dialect for HXTT JDBC drivers. Written according to Jboss'
 * dialect samples.
 */
public abstract class HxttDialect extends Dialect {

	static final String DEFAULT_BATCH_SIZE = "15";
	static final String NO_BATCH = "0";

	public HxttDialect() {
		super();
		// Mathematical Functions
		registerFunction("abs", new StandardSQLFunction("abs"));
		registerFunction("ceiling", new StandardSQLFunction("ceiling",
				IntegerType.INSTANCE));
		registerFunction("ceil", new StandardSQLFunction("ceil",
				IntegerType.INSTANCE));
		registerFunction("sign", new StandardSQLFunction("sign",
				IntegerType.INSTANCE));
		registerFunction("degrees", new StandardSQLFunction("degrees",
				DoubleType.INSTANCE));
		registerFunction("exp",
				new StandardSQLFunction("exp", DoubleType.INSTANCE));
		registerFunction("floor", new StandardSQLFunction("floor",
				IntegerType.INSTANCE));
		registerFunction("int", new StandardSQLFunction("int",
				IntegerType.INSTANCE));
		registerFunction("log",
				new StandardSQLFunction("log", DoubleType.INSTANCE));
		registerFunction("log10", new StandardSQLFunction("log10",
				DoubleType.INSTANCE));
		registerFunction("log2", new StandardSQLFunction("log2",
				DoubleType.INSTANCE));
		registerFunction("ln", new StandardSQLFunction("ln",
				DoubleType.INSTANCE));
		registerFunction("mod", new StandardSQLFunction("mod",
				IntegerType.INSTANCE));
		registerFunction("pi", new NoArgSQLFunction("pi", DoubleType.INSTANCE));
		registerFunction("pow",
				new StandardSQLFunction("pow", DoubleType.INSTANCE));
		registerFunction("power", new StandardSQLFunction("power",
				DoubleType.INSTANCE));
		registerFunction("padians", new StandardSQLFunction("padians",
				DoubleType.INSTANCE));
		registerFunction("radians", new StandardSQLFunction("radians",
				DoubleType.INSTANCE));
		registerFunction("rand", new NoArgSQLFunction("rand",
				DoubleType.INSTANCE));
		registerFunction("round", new StandardSQLFunction("round",
				IntegerType.INSTANCE));
		registerFunction("sign", new StandardSQLFunction("sign",
				IntegerType.INSTANCE));
		registerFunction("sqrt", new StandardSQLFunction("sqrt",
				DoubleType.INSTANCE));
		registerFunction("trunc", new StandardSQLFunction("trunc",
				DoubleType.INSTANCE));
		registerFunction("truncate", new StandardSQLFunction("truncate",
				DoubleType.INSTANCE));
		// Trigonometric Functions
		registerFunction("acos", new StandardSQLFunction("acos",
				DoubleType.INSTANCE));
		registerFunction("asin", new StandardSQLFunction("asin",
				DoubleType.INSTANCE));
		registerFunction("atan", new StandardSQLFunction("atan",
				DoubleType.INSTANCE));
		registerFunction("atan2", new StandardSQLFunction("atan2",
				DoubleType.INSTANCE));
		registerFunction("cos",
				new StandardSQLFunction("cos", DoubleType.INSTANCE));
		registerFunction("cot",
				new StandardSQLFunction("cot", DoubleType.INSTANCE));
		registerFunction("crc32", new StandardSQLFunction("crc32",
				LongType.INSTANCE));
		registerFunction("sin",
				new StandardSQLFunction("sin", DoubleType.INSTANCE));
		registerFunction("tan",
				new StandardSQLFunction("tan", DoubleType.INSTANCE));

		// String Functions
		registerFunction("alltrim", new StandardSQLFunction("alltrim"));
		registerFunction("asc", new StandardSQLFunction("asc",
				IntegerType.INSTANCE));
		registerFunction("ascii", new StandardSQLFunction("ascii",
				IntegerType.INSTANCE));
		registerFunction("at", new StandardSQLFunction("at",
				IntegerType.INSTANCE));
		registerFunction("bin",
				new StandardSQLFunction("bin", StringType.INSTANCE));
		registerFunction("bit_length", new StandardSQLFunction("bit_length",
				LongType.INSTANCE));
		registerFunction("char_length", new StandardSQLFunction("char_length",
				LongType.INSTANCE));
		registerFunction("character_length", new StandardSQLFunction(
				"character_length", LongType.INSTANCE));
		registerFunction("char", new StandardSQLFunction("char",
				StringType.INSTANCE));
		registerFunction("chr", new StandardSQLFunction("char",
				StringType.INSTANCE));
		registerFunction("chrtran", new StandardSQLFunction("chrtran",
				StringType.INSTANCE));
		registerFunction("concat", new VarArgsSQLFunction(StringType.INSTANCE,
				"",
				"||", ""));
		registerFunction("concat_ws", new VarArgsSQLFunction(
				StringType.INSTANCE,
				"", "||", ""));
		registerFunction("conv", new StandardSQLFunction("conv",
				StringType.INSTANCE));
		registerFunction("difference", new StandardSQLFunction("difference",
				StringType.INSTANCE));
		registerFunction("hex",
				new StandardSQLFunction("hex", StringType.INSTANCE));
		registerFunction("initcap", new StandardSQLFunction("initcap"));
		// registerFunction("insert", new StandardSQLFunction("insert") );
		registerFunction("instr", new StandardSQLFunction("instr",
				IntegerType.INSTANCE));
		registerFunction("lcase", new StandardSQLFunction("lcase"));
		registerFunction("left", new StandardSQLFunction("left",
				IntegerType.INSTANCE));
		registerFunction("len", new StandardSQLFunction("len",
				LongType.INSTANCE));
		registerFunction("length", new StandardSQLFunction("length",
				LongType.INSTANCE));
		registerFunction("locate", new StandardSQLFunction("locate",
				LongType.INSTANCE));
		registerFunction("lower", new StandardSQLFunction("lower"));
		registerFunction("lpad", new StandardSQLFunction("lpad",
				StringType.INSTANCE));
		registerFunction("ltrim", new StandardSQLFunction("ltrim"));
		registerFunction("mid",
				new StandardSQLFunction("mid", StringType.INSTANCE));
		registerFunction("oct",
				new StandardSQLFunction("oct", StringType.INSTANCE));
		registerFunction("octet_length", new StandardSQLFunction(
				"octet_length", LongType.INSTANCE));
		registerFunction("padc", new StandardSQLFunction("padc",
				StringType.INSTANCE));
		registerFunction("padl", new StandardSQLFunction("padl",
				StringType.INSTANCE));
		registerFunction("padr", new StandardSQLFunction("padr",
				StringType.INSTANCE));
		registerFunction("position", new StandardSQLFunction("position",
				IntegerType.INSTANCE));
		registerFunction("proper", new StandardSQLFunction("proper"));
		registerFunction("repeat", new StandardSQLFunction("repeat",
				StringType.INSTANCE));
		registerFunction("replicate", new StandardSQLFunction("replicate",
				StringType.INSTANCE));
		registerFunction("replace", new StandardSQLFunction("replace",
				StringType.INSTANCE));
		registerFunction("right", new StandardSQLFunction("right",
				IntegerType.INSTANCE));
		registerFunction("rpad", new StandardSQLFunction("rpad",
				StringType.INSTANCE));
		registerFunction("rtrim", new StandardSQLFunction("rtrim"));
		registerFunction("soundex", new StandardSQLFunction("soundex"));
		registerFunction("space", new StandardSQLFunction("space",
				StringType.INSTANCE));
		registerFunction("strcat", new VarArgsSQLFunction(StringType.INSTANCE,
				"",
				"||", ""));
		registerFunction("strcmp", new StandardSQLFunction("strcmp",
				IntegerType.INSTANCE));
		registerFunction("strconv", new StandardSQLFunction("strconv",
				StringType.INSTANCE));
		registerFunction("strtran", new StandardSQLFunction("strtran",
				StringType.INSTANCE));
		registerFunction("stuff", new StandardSQLFunction("stuff",
				StringType.INSTANCE));
		registerFunction("substr", new StandardSQLFunction("stuff",
				StringType.INSTANCE));
		registerFunction("substring", new StandardSQLFunction("substring",
				StringType.INSTANCE));
		registerFunction("translate", new StandardSQLFunction("translate",
				StringType.INSTANCE));
		registerFunction("trim", new StandardSQLFunction("trim"));
		registerFunction("ucase", new StandardSQLFunction("ucase"));
		registerFunction("upper", new StandardSQLFunction("upper"));
		registerFunction("charmirr", new StandardSQLFunction("charmirr"));
		registerFunction("reverse", new StandardSQLFunction("reverse"));

		// Date/Time Functions
		registerFunction("addtime", new StandardSQLFunction("addtime",
				TimestampType.INSTANCE));
		registerFunction("cdow", new StandardSQLFunction("cdow",
				StringType.INSTANCE));
		registerFunction("cmonth", new StandardSQLFunction("cmonth",
				StringType.INSTANCE));
		registerFunction("curdate", new NoArgSQLFunction("curdate",
				DateType.INSTANCE));
		registerFunction("curtime", new NoArgSQLFunction("curtime",
				TimeType.INSTANCE));
		registerFunction("date",
				new StandardSQLFunction("date", DateType.INSTANCE));
		registerFunction("datediff", new StandardSQLFunction("datediff",
				IntegerType.INSTANCE));
		registerFunction("datetime", new NoArgSQLFunction("datetime",
				TimestampType.INSTANCE));
		registerFunction("date_add", new StandardSQLFunction("date_add",
				DateType.INSTANCE));
		registerFunction("date_sub", new StandardSQLFunction("date_sub",
				DateType.INSTANCE));
		registerFunction("adddate", new StandardSQLFunction("adddate",
				DateType.INSTANCE));
		registerFunction("subdate", new StandardSQLFunction("subdate",
				DateType.INSTANCE));
		registerFunction("day", new StandardSQLFunction("day",
				IntegerType.INSTANCE));
		registerFunction("dayofmonth", new StandardSQLFunction("dayofmonth",
				IntegerType.INSTANCE));
		registerFunction("dayname", new StandardSQLFunction("dayname",
				StringType.INSTANCE));
		registerFunction("dayofweek", new StandardSQLFunction("dayofweek",
				IntegerType.INSTANCE));
		registerFunction("dayofyear", new StandardSQLFunction("dayofyear",
				IntegerType.INSTANCE));
		registerFunction("extract", new StandardSQLFunction("extract",
				IntegerType.INSTANCE));
		registerFunction("dow",
				new StandardSQLFunction("dow", StringType.INSTANCE));
		registerFunction("from_days", new StandardSQLFunction("from_days",
				DateType.INSTANCE));
		registerFunction("gomonth", new StandardSQLFunction("gomonth",
				DateType.INSTANCE));
		registerFunction("hour", new StandardSQLFunction("hour",
				IntegerType.INSTANCE));
		registerFunction("last_day", new StandardSQLFunction("last_day",
				DateType.INSTANCE));
		registerFunction("minute", new StandardSQLFunction("minute",
				IntegerType.INSTANCE));
		registerFunction("millisecond", new StandardSQLFunction("millisecond",
				IntegerType.INSTANCE));
		registerFunction("microsecond", new StandardSQLFunction("microsecond",
				IntegerType.INSTANCE));
		registerFunction("month", new StandardSQLFunction("month",
				IntegerType.INSTANCE));
		registerFunction("monthname", new StandardSQLFunction("monthname",
				StringType.INSTANCE));
		registerFunction("now",
				new NoArgSQLFunction("now", TimestampType.INSTANCE));
		registerFunction("quarter", new StandardSQLFunction("quarter",
				IntegerType.INSTANCE));
		registerFunction("second", new StandardSQLFunction("second",
				IntegerType.INSTANCE));
		registerFunction("sub_time", new NoArgSQLFunction("sub_time",
				TimestampType.INSTANCE));
		registerFunction("sysdate", new NoArgSQLFunction("sysdate",
				TimestampType.INSTANCE));
		registerFunction("time",
				new StandardSQLFunction("time", TimeType.INSTANCE));
		registerFunction("timediff", new StandardSQLFunction("timediff",
				TimeType.INSTANCE));
		registerFunction("timestamp", new StandardSQLFunction("timestamp",
				TimestampType.INSTANCE));
		registerFunction("timestampadd", new StandardSQLFunction(
				"timestampadd", TimestampType.INSTANCE));
		registerFunction("timestampdiff", new StandardSQLFunction(
				"timestampdiff", IntegerType.INSTANCE));
		registerFunction("to_days", new StandardSQLFunction("to_days",
				IntegerType.INSTANCE));
		registerFunction("week", new StandardSQLFunction("week",
				IntegerType.INSTANCE));
		registerFunction("weekofyear", new StandardSQLFunction("weekofyear",
				IntegerType.INSTANCE));
		registerFunction("year", new StandardSQLFunction("year",
				IntegerType.INSTANCE));
		// boolean functions
		registerFunction("empty", new StandardSQLFunction("empty",
				BooleanType.INSTANCE));
		registerFunction("isblank", new StandardSQLFunction("isblank",
				BooleanType.INSTANCE));
		registerFunction("isalpha", new StandardSQLFunction("isalpha",
				BooleanType.INSTANCE));
		registerFunction("isdigit", new StandardSQLFunction("isdigit",
				BooleanType.INSTANCE));
		registerFunction("isnull", new StandardSQLFunction("isnull",
				BooleanType.INSTANCE));
		// Conversion Functions
		registerFunction("cbool", new StandardSQLFunction("cbool",
				BooleanType.INSTANCE));
		registerFunction("cbyte", new StandardSQLFunction("cbyte",
				ByteType.INSTANCE));
		registerFunction("cdate", new StandardSQLFunction("cdate",
				DateType.INSTANCE));
		registerFunction("cdbl", new StandardSQLFunction("cdbl",
				DoubleType.INSTANCE));
		registerFunction("cint", new StandardSQLFunction("cint",
				IntegerType.INSTANCE));
		registerFunction("clng",
				new StandardSQLFunction("clng", LongType.INSTANCE));
		registerFunction("csng", new StandardSQLFunction("csng",
				FloatType.INSTANCE));
		registerFunction("cstr", new StandardSQLFunction("cstr",
				StringType.INSTANCE));
		registerFunction("ctod",
				new StandardSQLFunction("ctod", DateType.INSTANCE));
		registerFunction("ctot", new StandardSQLFunction("ctot",
				TimestampType.INSTANCE));
		registerFunction("dtoc", new StandardSQLFunction("dtoc",
				StringType.INSTANCE));
		registerFunction("dtot", new StandardSQLFunction("dtot",
				TimestampType.INSTANCE));
		registerFunction("ttoc", new StandardSQLFunction("ttoc",
				StringType.INSTANCE));
		registerFunction("ttod",
				new StandardSQLFunction("ttod", DateType.INSTANCE));
		// Security Functions
		registerFunction("compress", new StandardSQLFunction("compress",
				StringType.INSTANCE));
		registerFunction("uncompress", new StandardSQLFunction("uncompress",
				StringType.INSTANCE));
		registerFunction("encrypt", new StandardSQLFunction("encrypt",
				StringType.INSTANCE));
		registerFunction("decrypt", new StandardSQLFunction("decrypt",
				StringType.INSTANCE));
		registerFunction("encode", new StandardSQLFunction("encode",
				StringType.INSTANCE));
		registerFunction("decode", new StandardSQLFunction("decode",
				StringType.INSTANCE));
		registerFunction("md5",
				new StandardSQLFunction("md5", StringType.INSTANCE));
		registerFunction("crypt3", new StandardSQLFunction("crypt3",
				StringType.INSTANCE));
		// System Functions
		registerFunction("database", new NoArgSQLFunction("database",
				StringType.INSTANCE, false));
		registerFunction("user", new NoArgSQLFunction("user",
				StringType.INSTANCE,
				false));
		registerFunction("deleted", new NoArgSQLFunction("deleted",
				BooleanType.INSTANCE, false));
		registerFunction("reccount", new NoArgSQLFunction("reccount",
				LongType.INSTANCE, false));
		registerFunction("recno", new NoArgSQLFunction("recno",
				LongType.INSTANCE,
				false));
		registerFunction("rowlocked", new NoArgSQLFunction("rowlocked",
				BooleanType.INSTANCE, false));
		// Miscellaneous Functions
		registerFunction("nvl", new StandardSQLFunction("nvl"));
		registerFunction("ifnull", new StandardSQLFunction("ifnull"));

		getDefaultProperties().setProperty(Environment.MAX_FETCH_DEPTH, "2");
		getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
				DEFAULT_BATCH_SIZE);
	}

	// SEQUENCE support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Does this dialect support sequences?
	 * 
	 * @return True if sequences supported; false otherwise.
	 */
	@Override
	public final boolean supportsSequences() {
		return true;// false;
	}

	/**
	 * Does this dialect support "pooled" sequences. Not aware of a better name
	 * for this. Essentially can we specify the initial and increment values?
	 * 
	 * @return True if such "pooled" sequences are supported; false otherwise.
	 * @see #getCreateSequenceStrings(String, int, int)
	 * @see #getCreateSequenceString(String, int, int)
	 */
	@Override
	public boolean supportsPooledSequences() {
		return true;// false;
	}

	/**
	 * Generate the appropriate select statement to to retreive the next value
	 * of a sequence.
	 * <p/>
	 * This should be a "stand alone" select statement.
	 * 
	 * @param sequenceName
	 *            the name of the sequence
	 * @return String The "nextval" select string.
	 * @throws MappingException
	 *             If sequences are not supported.
	 */
	@Override
	public final String getSequenceNextValString(String sequenceName) {
		// SELECT NEXTVAL('SEQUENCENAME')
		// "select next_value of " + sequenceName + " from system.onerow";
		return "select " + getSelectSequenceNextValString(sequenceName);
	}

	/**
	 * Generate the select expression fragment that will retreive the next value
	 * of a sequence as part of another (typically DML) statement.
	 * <p/>
	 * This differs from {@link #getSequenceNextValString(String)} in that this
	 * should return an expression usable within another statement.
	 * 
	 * @param sequenceName
	 *            the name of the sequence
	 * @return The "nextval" fragment.
	 * @throws MappingException
	 *             If sequences are not supported.
	 */
	@Override
	public final String getSelectSequenceNextValString(String sequenceName) {
		return "nextval('" + sequenceName + "')";
	}

	/**
	 * Typically dialects which support sequences can create a sequence with a
	 * single command. This is convenience form of
	 * {@link #getCreateSequenceStrings} to help facilitate that.
	 * <p/>
	 * Dialects which support sequences and can create a sequence in a single
	 * command need *only* override this method. Dialects which support
	 * sequences but require multiple commands to create a sequence should
	 * instead override {@link #getCreateSequenceStrings}.
	 * 
	 * @param sequenceName
	 *            The name of the sequence
	 * @return The sequence creation command
	 * @throws MappingException
	 *             If sequences are not supported.
	 */
	@Override
	public final String getCreateSequenceString(String sequenceName) {
		// create sequence if not exists userID start WITH 100 increment by 2
		// maxvalue 2000 cache 5 cycle;
		return "create sequence " + sequenceName;
	}

	/**
	 * Typically dialects which support sequences can drop a sequence with a
	 * single command. This is convenience form of
	 * {@link #getDropSequenceStrings} to help facilitate that.
	 * <p/>
	 * Dialects which support sequences and can drop a sequence in a single
	 * command need *only* override this method. Dialects which support
	 * sequences but require multiple commands to drop a sequence should instead
	 * override {@link #getDropSequenceStrings}.
	 * 
	 * @param sequenceName
	 *            The name of the sequence
	 * @return The sequence drop commands
	 * @throws MappingException
	 *             If sequences are not supported.
	 */
	@Override
	public final String getDropSequenceString(String sequenceName) {
		// drop sequence if exists userID;
		return "drop sequence " + sequenceName;
	}

	/**
	 * Get the select command used retrieve the names of all sequences.
	 * 
	 * @return The select command; or null if sequences are not supported.
	 * @see org.hibernate.tool.hbm2ddl.SchemaUpdate
	 */
	@Override
	public final String getQuerySequencesString() {
		return null;
		// select sequence_name from domain.sequences";
		// "select sequence_schema || '.' || sequence_name from information_schema.ext_sequences";
	}

	// limit/offset support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Does this dialect support some form of limiting query results via a SQL
	 * clause?
	 * 
	 * @return True if this dialect supports some form of LIMIT.
	 */
	@Override
	public final boolean supportsLimit() {
		return true;// false;
	}

	/**
	 * ANSI SQL defines the LIMIT clause to be in the form LIMIT offset, limit.
	 * Does this dialect require us to bind the parameters in reverse order?
	 * 
	 * @return true if the correct order is limit, offset
	 */
	@Override
	public final boolean bindLimitParametersInReverseOrder() {
		return true;// false;
	}

	// IDENTITY support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Does this dialect support identity column key generation?
	 * 
	 * @return True if IDENTITY columns are supported; false otherwise.
	 */
	@Override
	public boolean supportsIdentityColumns() {
		return true;// false;
	}

	/**
	 * Whether this dialect have an Identity clause added to the data type or a
	 * completely seperate identity data type
	 * 
	 * @return boolean
	 */
	/*
	 * public boolean hasDataTypeInIdentityColumn() { return
	 * true;//false;//true; }
	 */

	/**
	 * Get the select command to use to retrieve the last generated IDENTITY
	 * value for a particuar table
	 * 
	 * @param table
	 *            The table into which the insert was done
	 * @param column
	 *            The PK column.
	 * @param type
	 *            The {@link java.sql.Types} type code.
	 * @return The appropriate select command
	 * @throws MappingException
	 *             If IDENTITY generation is not supported.
	 */
	@Override
	public final String getIdentitySelectString(String table, String column,
			int type) {
		// return getIdentitySelectString();
		return new StringBuffer().append("select currval('")
				.append(table)
				.append("','")
				.append(column)
				.append("')")
				.toString();
		/*
		 * return new StringBuffer().append("select currval('") .append(table)
		 * .append('_') .append(column) .append("_seq')") .toString(); return
		 * type==Types.BIGINT ?
		 * "select dbinfo('serial8') from systables where tabid=1" :
		 * "select dbinfo('sqlca.sqlerrd1') from systables where tabid=1";
		 */

	}

	/**
	 * Get the select command to use to retrieve the last generated IDENTITY
	 * value.
	 * 
	 * @return The appropriate select command
	 * @throws MappingException
	 *             If IDENTITY generation is not supported.
	 */
	/*
	 * public String getIdentitySelectString() { //return
	 * "select last_insert_id()"; return "select @@identity";
	 * //"select identity_val_local() from sysibm.sysdummy1" //call identity()"
	 * //"SELECT LAST_IDENTITY() FROM %TSQL_sys.snf"; }
	 */

	/**
	 * The syntax used during DDL to define a column as being an IDENTITY of a
	 * particular type.
	 * 
	 * @param type
	 *            The {@link java.sql.Types} type code.
	 * @return The appropriate DDL fragment.
	 * @throws MappingException
	 *             If IDENTITY generation is not supported.
	 */
	/*
	 * public String getIdentityColumnString(int type) { return
	 * getIdentityColumnString(); /* return type==Types.BIGINT ?
	 * "bigserial not null" : "serial not null"; return type==Types.BIGINT ?
	 * "serial8 not null" : "serial not null";
	 * 
	 * /
	 * 
	 * }
	 */

	/**
	 * The syntax used during DDL to define a column as being an IDENTITY.
	 * 
	 * @return The appropriate DDL fragment.
	 * @throws MappingException
	 *             If IDENTITY generation is not supported.
	 */
	@Override
	public final String getIdentityColumnString() {
		return "not null auto_increment"; // starts with 1, implicitly
		// return "identity not null"; //starts with 1, implicitly
		// "autoincrement";
		// identity";
		// return "generated by default as identity (start with 1)"; //not null
		// is implicit
	}

	/**
	 * The keyword used to insert a generated value into an identity column (or
	 * null). Need if the dialect does not support inserts that specify no
	 * column values.
	 * 
	 * @return The appropriate keyword.
	 */
	@Override
	public final String getIdentityInsertString() {
		// return null;
		return "null";
	}

	// lock acquisition support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Does this dialect support <tt>FOR UPDATE</tt> in conjunction with outer
	 * joined rows?
	 * 
	 * @return True if outer joined rows can be locked via <tt>FOR UPDATE</tt>.
	 */
	@Override
	public final boolean supportsOuterJoinForUpdate() {
		return false;// true;//???
	}

	// current timestamp support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Does this dialect support a way to retrieve the database's current
	 * timestamp value?
	 * 
	 * @return True if the current timestamp can be retrieved; false otherwise.
	 */
	@Override
	public final boolean supportsCurrentTimestampSelection() {
		return true;// false;
	}

	/**
	 * Should the value returned by {@link #getCurrentTimestampSelectString} be
	 * treated as callable. Typically this indicates that JDBC escape sytnax is
	 * being used...
	 * 
	 * @return True if the {@link #getCurrentTimestampSelectString} return is
	 *         callable; false otherwise.
	 */
	@Override
	public final boolean isCurrentTimestampSelectStringCallable() {
		return true;// ???
	}

	/**
	 * Retrieve the command used to retrieve the current timestammp from the
	 * database.
	 * 
	 * @return The command.
	 */
	@Override
	public final String getCurrentTimestampSelectString() {
		return "select now()";
		// "select systimestamp from dual"
		// "select now()";
		// "call current_timestamp()"
	}

	/**
	 * The name of the database-specific SQL function for retrieving the current
	 * timestamp.
	 * 
	 * @return The function name.
	 */
	@Override
	public final String getCurrentTimestampSQLFunctionName() {
		// the standard SQL function name is current_timestamp...
		return "now";// current_timestamp";
	}

	// union subclass support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Does this dialect support UNION ALL, which is generally a faster variant
	 * of UNION?
	 * 
	 * @return True if UNION ALL is supported; false otherwise.
	 */
	@Override
	public final boolean supportsUnionAll() {
		return true;// false;
	}

	// miscellaneous support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * The fragment used to insert a row without specifying any column values.
	 * This is not possible on some databases.
	 * 
	 * @return The appropriate empty values clause.
	 */
	@Override
	public final String getNoColumnsInsertString() {
		return "values ( )";// ???Doesn't support now.'
		// return "default values";
	}

	/**
	 * The SQL literal value to which this database maps boolean values.
	 * 
	 * @param bool
	 *            The boolean value
	 * @return The appropriate SQL literal.
	 */
	@Override
	public final String toBooleanValueString(boolean bool) {
		return bool ? "true" : "false";
	}

	// DDL support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Do we need to drop constraints before dropping tables in this dialect?
	 * 
	 * @return True if constraints must be dropped prior to dropping the table;
	 *         false otherwise.
	 */
	@Override
	public final boolean dropConstraints() {
		return false;// true;
	}

	/**
	 * Do we need to qualify index names with the schema name?
	 * 
	 * @return boolean
	 */
	@Override
	public final boolean qualifyIndexName() {
		return false;// true;
	}

	/**
	 * The syntax used to add a column to a table (optional).
	 * 
	 * @return The "add column" fragment.
	 */
	@Override
	public final String getAddColumnString() {
		// ALTER table TBNAME ADD COLUMN FIELDNAME FIELDTYPE
		return "add column";
	}

	@Override
	public final String getDropForeignKeyString() {
		throw new UnsupportedOperationException(
				"No drop foreign key foreign supported by Hxtt Dialect");
		// return " drop constraint ";
	}

	/**
	 * The syntax used to add a primary key constraint to a table.
	 * 
	 * @param constraintName
	 *            The name of the PK constraint.
	 * @return The "add PK" fragment
	 */
	@Override
	public final String getAddPrimaryKeyConstraintString(String constraintName) {
		return " primary key ";
		// return " add constraint " + constraintName + " primary key ";
	}

	/**
	 * The keyword used to specify a nullable column.
	 * 
	 * @return String
	 */
	@Override
	public final String getNullColumnString() {
		return " null";
	}

	@Override
	public final boolean supportsIfExistsBeforeTableName() {
		return true;// false;
	}

	/**
	 * Does this dialect support column-level check constraints?
	 * 
	 * @return True if column-level CHECK constraints are supported; false
	 *         otherwise.
	 */
	@Override
	public final boolean supportsColumnCheck() {
		return false;// true;//Support little
	}

	/**
	 * Does this dialect support table-level check constraints?
	 * 
	 * @return True if table-level CHECK constraints are supported; false
	 *         otherwise.
	 */
	@Override
	public final boolean supportsTableCheck() {
		return false;// true;
	}

	@Override
	public boolean supportsCascadeDelete() {
		return false;// true; HXTT Access supports
	}

	/**
	 * Is this dialect known to support what ANSI-SQL terms "row value
	 * constructor" syntax; sometimes called tuple syntax.
	 * <p/>
	 * Basically, does it support syntax like
	 * "... where (FIRST_NAME, LAST_NAME) = ('Steve', 'Ebersole') ...".
	 * 
	 * @return True if this SQL dialect is known to support "row value
	 *         constructor" syntax; false otherwise.
	 * @since 3.2
	 */
	@Override
	public final boolean supportsRowValueConstructorSyntax() {
		// return false here, as most databases do not properly support this
		// construct...
		return true;// false;
	}

	/**
	 * If the dialect supports {@link #supportsRowValueConstructorSyntax() row
	 * values}, does it offer such support in IN lists as well?
	 * <p/>
	 * For example,
	 * "... where (FIRST_NAME, LAST_NAME) IN ( (?, ?), (?, ?) ) ..."
	 * 
	 * @return True if this SQL dialect is known to support "row value
	 *         constructor" syntax in the IN list; false otherwise.
	 * @since 3.2
	 */
	@Override
	public final boolean supportsRowValueConstructorSyntaxInInList() {
		return true;// false;
	}

	/**
	 * Should LOBs (both BLOB and CLOB) be bound using stream operations (i.e.
	 * {@link java.sql.PreparedStatement#setBinaryStream}).
	 * 
	 * @return True if BLOBs and CLOBs should be bound using stream operations.
	 * @since 3.2
	 */
	@Override
	public final boolean useInputStreamToInsertBlob() {
		return false;// true;//???
	}

	/**
	 * Does this dialect support definition of cascade delete constraints which
	 * can cause circular chains?
	 * 
	 * @return True if circular cascade delete constraints are supported; false
	 *         otherwise.
	 * @since 3.2
	 */
	@Override
	public final boolean supportsCircularCascadeDeleteConstraints() {
		return false;// true; //??? MS Access doesn't support too?
	}

}
