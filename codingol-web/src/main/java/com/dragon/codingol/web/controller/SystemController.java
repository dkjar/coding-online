package com.dragon.codingol.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.druid.util.StringUtils;
import com.dragon.codingol.common.Pager;
import com.dragon.codingol.common.ResultJson;
import com.dragon.codingol.common.SystemConfig;
import com.dragon.codingol.domain.admin.SystemEntity;
import com.dragon.codingol.service.system.SystemService;
import com.dragon.codingol.web.common.JsonCommon;

@Controller("systemController")
@RequestMapping("/systemController")
public class SystemController {

	@Autowired
	private SystemService systemService;
	@Autowired
	private JsonCommon jsonCommon;

	@RequestMapping("/index")
	public String index() {
		return "system/index.jsp";
	}

	@RequestMapping("/indexdata")
	public void indexdata(Pager page, HttpServletRequest request,
			HttpServletResponse response) {
		List<SystemEntity> systems = systemService.loadAll(SystemEntity.class);
		page.setTotal(200);
		page.setRows(systems);
		jsonCommon.jsonReturn(page, response);
	}

	@RequestMapping("/edit")
	public String edit(SystemEntity system, HttpServletRequest request) {
		if (!StringUtils.isEmpty(system.getId()))
			request.setAttribute("systems",
					systemService.get(SystemEntity.class, system.getId()));
		return "system/edit.jsp";
	}

	@RequestMapping(params = "save")
	public void save(SystemEntity system, HttpServletRequest request,
			HttpServletResponse response) {
		ResultJson r = new ResultJson();
		try {
			this.systemService.save(system);
		} catch (Exception e) {
			r.setSuccess(false);
			r.setMsg(e.getMessage());
		}

		jsonCommon.jsonReturn(r, response);
	}

	/**
	 * 显示图片
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @throws IOException
	 */
	@RequestMapping("/image")
	public void image(HttpServletRequest request, HttpServletResponse response,
			String path) throws IOException {
		String basePath = SystemConfig.getFileUploadTemp();
		if (!basePath.endsWith("/")) {
			basePath += "/";
		}
		File file = new File(basePath + path);
		if(!file.exists())
			return;
		FileInputStream hFile = new FileInputStream(file); // 以byte流的方式打开文件

		int i = hFile.available(); // 得到文件大小
		byte data[] = new byte[i];
		hFile.read(data); // 读数据
		response.setContentType("image/*"); // 设置返回的文件类型
		OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
		toClient.write(data); // 输出数据
		toClient.flush();
		toClient.close();
		hFile.close();

	}

	@RequestMapping("/file")
	public void file(HttpServletRequest request, HttpServletResponse response,
			String path) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/imageUpload")
	@ResponseBody
	public void imageUpload(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;
		ResultJson r = new ResultJson();
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());

			String newFilenameBase = UUID.randomUUID().toString();
			String originalFileExtension = mpf.getOriginalFilename().substring(
					mpf.getOriginalFilename().lastIndexOf("."));
			String newFilename = newFilenameBase + originalFileExtension;
			String storageDirectory = SystemConfig.getFileUploadTemp();
			String contentType = mpf.getContentType();
			File newFile = new File(storageDirectory + "/" + newFilename);
			try {
				mpf.transferTo(newFile);
				r.setMsg(newFilename);
			} catch (IOException e) {
				r.setFailure(e.getMessage());
			}
		}
		jsonCommon.jsonReturn(r, response);
	}
	
	@RequestMapping(value = "/upload")
	@ResponseBody
	public void upload(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;
		ResultJson r = new ResultJson();
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());

			String newFilenameBase = UUID.randomUUID().toString();
			String originalFileExtension = mpf.getOriginalFilename().substring(
					mpf.getOriginalFilename().lastIndexOf("."));
			String newFilename = newFilenameBase + originalFileExtension;
			String storageDirectory = SystemConfig.getFileUploadTemp();
			String contentType = mpf.getContentType();
			File newFile = new File(storageDirectory + "/" + newFilename);
			try {
				mpf.transferTo(newFile);
				r.setMsg(newFilename);
			} catch (IOException e) {
				r.setFailure(e.getMessage());
			}
		}
		jsonCommon.jsonReturn(r, response);
	}

}
