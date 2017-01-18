package com.erp.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;












import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyjz.icop.base.service.IBaseService;
import com.yyjz.icop.matadata.entity.PubMdClassEntity;
import com.yyjz.icop.matadata.entity.PubMdColumnEntity;
import com.yyjz.icop.matadata.service.IPubMdService;
import com.yyjz.icop.materialmgr.materialAgreement.entity.MmAgreementEntity;
import com.yyjz.icop.materialmgr.materialAgreement.vo.MmAgreementVO;


@Controller
@RequestMapping("test")
public class TestController {
	public TestController(){
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
		System.out.println("我创建了--------------------------------");
	}
	
	@Autowired
	private IPubMdService pubMdService;
	@Autowired
	private IBaseService baseService;
	@RequestMapping("hello2")
	@ResponseBody
	@Transactional
	public String Test2() {
		//System.out.println(pubMdService.findPubMdColumnById("1").getId());
		Map vo = new HashMap();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap();
		
		////多子测试
/*		map1.put("memo", "333");
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map3 = new HashMap();
		Map<String, Object> map4 = new HashMap();
		map3.put("name", "linan1");
		map4.put("name", "linan2");
		list1.add(map3);
		list1.add(map4);
		Map<String, Object> map2 = new HashMap();
		map2.put("memo", "444");
		list.add(map2);
		list.add(map1);
		vo.put("billCode", "testtestetstets");	
		vo.put("childrenDetail",list);
		vo.put("chlid",list1);
		*/
		
		//////////  子孙测试
		map1.put("memo", "333");
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map3 = new HashMap();
		Map<String, Object> map4 = new HashMap();
		map3.put("name", "linan1");
		map4.put("name", "linan2");
		list1.add(map3);
		list1.add(map4);
		Map<String, Object> map2 = new HashMap();
		map2.put("memo", "444");
		map1.put("chlid",list1);
		map2.put("chlid",list1);
		list.add(map2);
		list.add(map1);
		vo.put("billCode", "testtestetstets");	
		vo.put("childrenDetail",list);  	
		try {
			baseService.save(vo, MmAgreementEntity.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success！";
	}
	@RequestMapping("hello3")
	@ResponseBody	
	public String Test3(){
		List<String> list = new ArrayList<String>();
		//list.add("billCode");
		list.add("billDate");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conditionValue", "2");
		try {
			
			//return baseService.getQuerySql("test", map, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return " no sql find";
	}
	
	@RequestMapping("hello4")
	@ResponseBody	
	public PubMdClassEntity Test4() throws Exception{
		return pubMdService.findMdClassEntityByBillType("MM20");
	}
	@RequestMapping("hello5")
	@ResponseBody	
	public Page<MmAgreementVO> Test5(){
		try {
		//baseService.deleteById(MmAgreementVO.class, "14682547f86645fd93be8b0e9c4271b7");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*List<String> list = new ArrayList<String>();
		//list.add("billCode");
		list.add("billDate");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conditionValue", "2");
		map.put("pageNumber", "0");
		map.put("pageSize", "10");
		Pageable pageable = null;
		String pageNumber = (String) map.get("pageNumber");
		String pageSize = (String) map.get("pageSize");
		String sortField = (String) map.get("sortField");
		String sortType = (String) map.get("sortType");
		if (!StringUtils.isEmpty(pageNumber)
				&& !StringUtils.isEmpty(pageSize)) {
			int iPageNumber = Integer.parseInt(pageNumber);
			if (!StringUtils.isEmpty(sortField)
					&& !StringUtils.isEmpty(sortType)) {
				pageable = new PageRequest(iPageNumber <= 0 ? 0
						: (iPageNumber - 1), Integer.parseInt(pageSize),
						Sort.Direction.fromStringOrNull(sortType),
						sortField);
			} else {
				pageable = new PageRequest(iPageNumber <= 0 ? 0
						: (iPageNumber - 1), Integer.parseInt(pageSize));
			}
		}
		try {		
			return baseService.queryPage(map, list, pageable, MmAgreementVO.class);     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}
	

}
