package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaGoodsRecommend;
import my.project.washingcar.model.GoodsRecommend;
import my.project.washingcar.view.HeaderView;
import my.project.washingcar.view.NoScrollGridView;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActShopDetail extends ActBase implements OnClickListener {

	private TextView currentPrice, originalPrice, soldCount;
	private Button btnBuyNow;
	private TextView introTitle, introContent, phoneNum, workPeriod, address;
	private TextView detailContent, detailImage;
	private NoScrollGridView goodsGridView;

	private List<GoodsRecommend> goodsList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_shop_detail);
		init();
	}

	private void init() {
		initAbView();
		initView();
		initGoodsGridView();
	}

	private void initAbView() {
		HeaderView header = (HeaderView) findViewById(R.id.header_detail);
		header.setTitle(R.string.header_title_detail);
		header.setOnBackListener(this);
	}

	private void initView() {
		originalPrice = (TextView) findViewById(R.id.detail_original_price);
		originalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
	}

	private void initGoodsGridView() {
		goodsList = new ArrayList<GoodsRecommend>();
		goodsGridView = (NoScrollGridView) findViewById(R.id.goods_recommend);
		for (int i = 0; i < 4; i++) {
			goodsList.add(new GoodsRecommend());
		}
		goodsGridView.setAdapter(new AdaGoodsRecommend(this, goodsList));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			onBackPressed();
			break;
		case R.id.detail_star:

			break;
		default:
			break;
		}
	}

}
