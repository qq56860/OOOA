package org.lanqiao.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.lanqiao.entity.Employee;



/**
 * 将集合中的数据转成excel并保存到服务器某个目录中（项目根目录）
 * @author yhy
 *
 */
public class CreateUserXLS {
	//指定path路径
	private String path;

	// 构造函数获取保存excel的路径
	public CreateUserXLS(String path) {
		this.path = path;
	}

	public Boolean CreateExcel(List<Employee> userList) {
		Boolean flag = true;

		// 创建一个工作簿
		HSSFWorkbook workBook = new HSSFWorkbook();
		// 创建一个工作表，名为：第一页
		HSSFSheet sheet = workBook.createSheet("员工信息表");

		// 设置单元格的宽度(0:表示第一行的第一个单元格，1：第一行的第二个单元格)
		sheet.setColumnWidth((short) 0, 3500);
		sheet.setColumnWidth((short) 1, 5000);
		sheet.setColumnWidth((short) 2, 5000);
		sheet.setColumnWidth((short) 3, 5000);
		sheet.setColumnWidth((short) 4, 5000);
		sheet.setColumnWidth((short) 5, 5000);

		// 创建一个单元格，从0开始
		HSSFRow row = sheet.createRow((short) 0);
		// 构造一个数组设置第一行之后的单元格
		HSSFCell cell[] = new HSSFCell[6];
		for (int i = 0; i < 6; i++) {
			cell[i] = row.createCell(i);
		}
		cell[0].setCellValue("姓名");
		cell[1].setCellValue("性别");
		cell[2].setCellValue("年龄");
		cell[3].setCellValue("部门");
		cell[4].setCellValue("电话");
		cell[5].setCellValue("地址");
		
		

		// 获得从数据库中查询出来的数据

		if (userList != null && userList.size() > 0) {

			// 循环list中的数据
			for (int i = 0; i < userList.size(); i++) {
				Employee user=  userList.get(i);
				HSSFRow dataRow = sheet.createRow(i + 1);
				//创建6个单元格
				HSSFCell data[] = new HSSFCell[6];
				for (int j = 0; j < 6; j++) {
					//每行创建6个单元格
					data[j] = dataRow.createCell(j);
				}
				//给单元格赋值,根据实际的集合数据填写
				data[0].setCellValue(user.geteName());
				data[1].setCellValue(user.geteSex());
				data[2].setCellValue(user.geteAge());
				data[3].setCellValue(user.getDepartment());
				data[4].setCellValue(user.geteTel());
				data[5].setCellValue(user.geteAddress());
				try {
					// 输出成XLS文件
					File file = new File(path);
					//保存文件
					FileOutputStream fos = new FileOutputStream(file
							+ "\\employee.xls");
					// 写入数据，并关闭文件
					workBook.write(fos);
					fos.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
					flag = false;
				} catch (IOException e) {
					e.printStackTrace();
					flag = false;
				}
			}
		}
		return flag;
	}

}
