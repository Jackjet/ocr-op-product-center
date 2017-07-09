package ocr.op.product.spu;

import java.util.ArrayList;
import java.util.List;

import otocloud.framework.app.function.AppActivityImpl;
import otocloud.framework.core.OtoCloudEventDescriptor;
import otocloud.framework.core.OtoCloudEventHandlerRegistry;

/**
 * TODO: 商品管理组件
 * @date 2016年11月26日
 * @author lijing
 */
public class ProductComponent extends AppActivityImpl {

	//业务活动组件名
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "product-spu";
	}
	
	//业务活动组件要处理的核心业务对象
	@Override
	public String getBizObjectType() {
		// TODO Auto-generated method stub
		return "p_ba_product";
	}


	//发布此业务活动对外暴露的业务事件
	@Override
	public List<OtoCloudEventDescriptor> exposeOutboundBizEventsDesc() {
		// TODO Auto-generated method stub
		return null;
	}


	//业务活动组件中的业务功能
	@Override
	public List<OtoCloudEventHandlerRegistry> registerEventHandlers() {
		// TODO Auto-generated method stub
		List<OtoCloudEventHandlerRegistry> ret = new ArrayList<OtoCloudEventHandlerRegistry>();
		
		ProductCreateHandler productCreateHandler = new ProductCreateHandler(this);
		ret.add(productCreateHandler);

		ProductQueryHandler queryHandler = new ProductQueryHandler(this);
		ret.add(queryHandler);
		
		ProductRemoveHandler productRemoveHandler = new ProductRemoveHandler(this);
		ret.add(productRemoveHandler);
		
		ProductUpdateHandler productUpdateHandler = new ProductUpdateHandler(this);
		ret.add(productUpdateHandler);
		
		ProductFindOneQueryHandler productFindOneQueryHandler = new ProductFindOneQueryHandler(this);
		ret.add(productFindOneQueryHandler);
		
		return ret;
	}

}
