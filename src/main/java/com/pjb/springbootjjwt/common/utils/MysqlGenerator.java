package com.pjb.springbootjjwt.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MysqlGenerator {

	/**
	 * <p>
	 * MySQL 生成演示
	 * </p>
	 */
	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("D:\\generator");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor("华商三优");

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setMapperName("%sDao");
		gc.setXmlName("%sDao");
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setControllerName("%sController");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		com.baomidou.mybatisplus.generator.config.DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert() {
			// 自定义数据库表字段类型转换【可选】
			@Override
			public DbColumnType processTypeConvert(String fieldType) {
				System.out.println("转换类型：" + fieldType);

				String t = fieldType.toLowerCase();
				if (t.contains("char") || t.contains("text")) {
					return DbColumnType.STRING;
				} else if (t.contains("bigint")) {
					return DbColumnType.LONG;
				} else if (t.contains("tinyint")) {
					return DbColumnType.BOOLEAN;
				} else if (t.contains("int")) {
					return DbColumnType.INTEGER;
				} else if (t.contains("date") || t.contains("time") || t.contains("year")) {
					return DbColumnType.DATE;
				} else if (t.contains("text")) {
					return DbColumnType.STRING;
				} else if (t.contains("bit")) {
					return DbColumnType.BOOLEAN;
				} else if (t.contains("decimal")) {
					return DbColumnType.DOUBLE;
				} else if (t.contains("clob")) {
					return DbColumnType.CLOB;
				} else if (t.contains("blog")) {
					return DbColumnType.BLOB;
				} else if (t.contains("binary")) {
					return DbColumnType.BYTE_ARRAY;
				} else if (t.contains("float")) {
					return DbColumnType.FLOAT;
				} else if (t.contains("double")) {
					return DbColumnType.DOUBLE;
				} else if (t.contains("json") || t.contains("enum")) {
					return DbColumnType.STRING;
				}
				return DbColumnType.STRING;

				// 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
				// return super.processTypeConvert(fieldType);
			}
		});
		dsc.setDriverName("com.mysql.jdbc.Driver");
		// dsc.setUsername("root");
		// dsc.setPassword("Root123qwe!@#");
		// dsc.setUrl("jdbc:mysql://localhost:3306/bimoa?characterEncoding=utf8&useSSL=false");
		dsc.setUsername("root");
		dsc.setPassword("o5jwc9d623h8w");

		dsc.setUrl("jdbc:mysql://1.119.155.58:33060/cdy_dev?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
		// useUnicode\=true&characterEncoding\=UTF-8&zeroDateTimeBehavior\=convertToNull
		// dsc.setUrl("jdbc:mysql://127.0.0.1:3306/gbi?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
		// strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });//
		// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		// String temp =
		// "check_item_detail_attachment,check_item_dict,check_item_score,check_plan,check_plan_attachment,check_plan_project_item,check_plan_template_rs,check_template,check_type_dict,check_type_scorecheck_item_detail_attachment,check_item_dict,check_item_score,check_plan,check_plan_attachment,check_plan_project_item,check_plan_template_rs,check_template,check_type_dict,check_type_score";

		strategy.setInclude(new String[] {

				"t_user_sys", "t_user_role", "t_role", "t_role_authority", "t_authority" }); // 需要生成的表
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表，与setInclude二选一配置
		// strategy.setInclude(new String[] { "audit_enterprise" }); // 需要生成的表
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表
		// 自定义实体父类
		// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
		// 自定义实体，公共字段
		// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// 自定义 mapper 父类
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// 自定义 service 父类
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// 自定义 service 实现类父类
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// 自定义 controller 父类
		// strategy.setSuperControllerClass("com.baomidou.demo.TestController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuliderModel(true);

		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.cdy.service.user");
		pc.setEntity("entity");
		pc.setController("controller");
		pc.setXml("dao");
		pc.setMapper("dao");
		pc.setService("service");
		mpg.setPackageInfo(pc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};

		// 自定义 xxList.jsp 生成
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		// focList.add(new FileOutConfig("/template/list.jsp.vm") {
		// @Override
		// public String outputFile(TableInfo tableInfo) {
		// // 自定义输入文件名称
		// return "D://my_" + tableInfo.getEntityName() + ".jsp";
		// }
		// });
		// cfg.setFileOutConfigList(focList);
		// mpg.setCfg(cfg);

		// 调整 xml 生成目录演示
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 关闭默认 xml 生成，调整生成 至 根目录
		// TemplateConfig tc = new TemplateConfig();
		// tc.setXml(null);
		// mpg.setTemplate(tc);

		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
		// 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		// TemplateConfig tc = new TemplateConfig();
		// tc.setController("...");
		// tc.setEntity("...");
		// tc.setMapper("...");
		// tc.setXml("...");
		// tc.setService("...");
		// tc.setServiceImpl("...");
		// 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
		// mpg.setTemplate(tc);

		// 执行生成
		mpg.execute();

		// 打印注入设置【可无】
		// System.err.println(mpg.getCfg().getMap().get("abc"));
	}

}
