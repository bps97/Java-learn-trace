package cn.bps.controller;

import cn.bps.pojo.*;
import cn.bps.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RequestMapping("/order")
@Controller
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private AdministrativeAreaService administrativeAreaService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/postAddress")
    @ResponseBody
    public String ajaxAddAddress(@ModelAttribute Address address,
                                HttpSession session){


        if(session.getAttribute("userId") == null)
            return "0";

        Integer userId = (Integer) session.getAttribute("userId");

        address.setUser_id(userId);
        address.setProvince(administrativeAreaService.getCityNameByCityCode(address.getProvince()));
        address.setPrefecture(administrativeAreaService.getCityNameByCityCode(address.getPrefecture()));
        address.setCounty(administrativeAreaService.getCityNameByCityCode(address.getCounty()));

        addressService.addAddress(address);

        return "1";
    }

	@RequestMapping(value = "/delAddress")
    @ResponseBody
    public Integer ajaxDelAddress(@RequestParam int addressId){
        return addressService.delAddressByAddressID(addressId);
    }

	@RequestMapping(value = "/setDefaultAddress")
    @ResponseBody
    public Integer ajaxSetDefaultAddress(@RequestParam int addressId){

        return addressService.updateSetDefaultAddressById(addressId);

    }

	@RequestMapping(value = "/addArea.do")
    @ResponseBody
    public Map<String, String> ajaxGetAdministrativeArea(@RequestParam(defaultValue = "0")String parentCode){
        List<AdministrativeArea> administrativeAreas = administrativeAreaService.getChildrenCities(parentCode);

        return administrativeAreaService.toTuple(administrativeAreas);
    }

	@RequestMapping(value = "")
    public String generatorOrder(@RequestParam(defaultValue = "0")Integer[] items,
                                 Model model,HttpSession session){

        if(session.getAttribute("userId") == null)

            return "0";

        if(items[0] == 0){
            return  "0";
        }

        int userId = (Integer)session.getAttribute("userId");
//        int userId = 1;

        List<Integer> itemList = Arrays.asList(items);

        List<ProductItem> productItems =  shoppingCartService.getShoppingCartByIds(itemList);
        model.addAttribute("productItems",productItems);

        Map<Integer, Product> productMap = productService.getProductMapByShoppingCartList(productItems);
        model.addAttribute("productMap",productMap);

        Map<Integer, String> urls = productImageService.getImageUrls(productMap.values());
        model.addAttribute("images",urls);

        List<AdministrativeArea> provinces = administrativeAreaService.getProvinces();
        model.addAttribute("province",provinces);

        List<AdministrativeArea> prefectures = administrativeAreaService.getChildrenCities(provinces.get(0).getCode());
        model.addAttribute("prefectures",prefectures);

        List<AdministrativeArea> counties = administrativeAreaService.getChildrenCities(prefectures.get(0).getCode());
        model.addAttribute("counties",counties);

        List<Address> addresses = addressService.getAddressesByUserIdExceptDefault(userId);
        model.addAttribute("addresses",addresses);

        Address defaultAddress = addressService.getDefaultAddressByUserId(userId);
        model.addAttribute("defaultAddress",defaultAddress);

        float totalPrice = shoppingCartService.countTotalPrice(productItems);
        model.addAttribute("totalPrice",totalPrice);

        String orderCode= orderService.generatorOrder(userId);
        //初始化订单
        orderItemService.addOrderItems(orderCode,productItems);

        if(orderCode!=null){
            //除去购物车内对应商品
            shoppingCartService.removeProductItemsByIds(itemList);
            model.addAttribute("orderCode", orderCode);
            return "/order";


        }

        return "0";

    }

	@RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submitOrder(@RequestParam(value = "message",defaultValue = "")String message,
                              @RequestParam("orderCode")String orderCode,
                              @RequestParam("addressId")Integer addressId,
                              @RequestParam("payment") Float payment,
                              RedirectAttributes redirectAttributes){
        Address address = addressService.getAddressByAddressID(addressId);


        Order order = orderService.summitOrder(orderCode,message, address,payment);


        redirectAttributes.addAttribute("actualCost", order.getActual_payment());
        redirectAttributes.addAttribute("orderCode", order.getOrder_code());


        if(order != null){

            return "redirect:/pay";
        }

        return "redirect: /order";
    }

	@RequestMapping(value = "/confirm")
    public String confirmOrder(@RequestParam("alipayInfo")String orderCode){


        Order order = orderService.confirmOrder(orderCode);
        if(order!=null){
            return "redirect:/shop";
        }


        return null;
    }


}
