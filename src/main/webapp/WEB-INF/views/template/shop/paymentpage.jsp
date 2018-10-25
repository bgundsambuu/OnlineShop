<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/22/2018
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>

<div class="container product_section_container">
    <div class="billing_details">
        <div class="row">
            <div class="col-lg-8">
                <h3>Billing Details</h3>
                <div class="p-3 p-lg-5 border">
                    <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                        <div class="col-md-6 form-group p_star">
                            <input type="text" class="form-control" id="first" name="name">
                            <span class="placeholder" data-placeholder="First name"></span>
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <input type="text" class="form-control" id="last" name="name">
                            <span class="placeholder" data-placeholder="Last name"></span>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="company" name="company"
                                   placeholder="Company name">
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <input type="text" class="form-control" id="number" name="number">
                            <span class="placeholder" data-placeholder="Phone number"></span>
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <input type="text" class="form-control" id="email" name="compemailany">
                            <span class="placeholder" data-placeholder="Email Address"></span>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <select class="country_select" style="display: none;">
                                <option value="1">Country</option>
                                <option value="2">Country</option>
                                <option value="4">Country</option>
                            </select>
                            <div class="nice-select country_select" tabindex="0"><span class="current">Country</span>
                                <ul class="list">
                                    <li data-value="1" class="option selected">Country</li>
                                    <li data-value="2" class="option">Country</li>
                                    <li data-value="4" class="option">Country</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <input type="text" class="form-control" id="add1" name="add1">
                            <span class="placeholder" data-placeholder="Address line 01"></span>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <input type="text" class="form-control" id="add2" name="add2">
                            <span class="placeholder" data-placeholder="Address line 02"></span>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <input type="text" class="form-control" id="city" name="city">
                            <span class="placeholder" data-placeholder="Town/City"></span>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <select class="country_select" style="display: none;">
                                <option value="1">District</option>
                                <option value="2">District</option>
                                <option value="4">District</option>
                            </select>
                            <div class="nice-select country_select" tabindex="0"><span class="current">District</span>
                                <ul class="list">
                                    <li data-value="1" class="option selected">District</li>
                                    <li data-value="2" class="option">District</li>
                                    <li data-value="4" class="option">District</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="zip" name="zip" placeholder="Postcode/ZIP">
                        </div>
                        <div class="col-md-12 form-group">
                            <div class="creat_account">
                                <input type="checkbox" id="f-option2" name="selector">
                                <label for="f-option2">Create an account?</label>
                            </div>
                        </div>
                        <div class="col-md-12 form-group" style="width: auto; overflow: hidden;">
                            <div class="creat_account">
                                <h3>Shipping Details</h3>
                                <input type="checkbox" id="f-option3" name="selector">
                                <label for="f-option3">Ship to a different address?</label>
                            </div>
                            <grammarly-ghost spellcheck="false">
                                <div data-id="a4d8f968-c513-b893-ec3d-20b287251c12"
                                     data-gramm_id="a4d8f968-c513-b893-ec3d-20b287251c12" data-gramm="gramm"
                                     data-gramm_editor="true" class="gr_ver_2" gramm="true" contenteditable="true"
                                     style="position: absolute; color: transparent; overflow: hidden; white-space: pre-wrap; border-radius: 3px; box-sizing: border-box; height: 150px; width: 750px; margin: 109px 0px 0px 15px; padding: 6px 12px 6px 20px; z-index: 0; border-width: 1px; border-style: solid; background: none 0% 0% / auto repeat scroll padding-box padding-box rgb(255, 255, 255); top: 0px; left: 0px;">
                                    <span style="display: inline-block; font: 400 13px/26px Roboto, sans-serif; color: transparent; overflow: hidden; text-align: left; float: initial; clear: none; box-sizing: border-box; vertical-align: baseline; white-space: pre-wrap; width: 100%; margin: 0px; padding: 0px; border: 0px; letter-spacing: normal; text-shadow: none; height: 148px;"></span><br>
                                </div>
                            </grammarly-ghost>
                            <textarea class="form-control" name="message" id="message" rows="1"
                                      placeholder="Order Notes" data-gramm="true"
                                      data-txt_gramm_id="a4d8f968-c513-b893-ec3d-20b287251c12"
                                      data-gramm_id="a4d8f968-c513-b893-ec3d-20b287251c12" spellcheck="false"
                                      data-gramm_editor="true"
                                      style="z-index: auto; position: relative; line-height: 26px; font-size: 13px; transition: none 0s ease 0s; background: transparent !important;"></textarea>
                            <grammarly-btn>
                                <div class="_1BN1N Kzi1t MoE_1 _2DJZN"
                                     style="z-index: 2; transform: translate(734px, 228px);">
                                    <div class="_1HjH7">
                                        <div title="Protected by Grammarly" class="_3qe6h">&nbsp;</div>
                                    </div>
                                </div>
                            </grammarly-btn>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="order_box">
                    <h3>Your Order</h3>
                    <div class="p-3 p-lg-5 border">
                        <ul class="list">
                            <li>
                                <a href="#">Product
                                    <span>Total</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">Fresh Blackberry
                                    <span class="middle">x 02</span>
                                    <span class="last">$720.00</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">Fresh Tomatoes
                                    <span class="middle">x 02</span>
                                    <span class="last">$720.00</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">Fresh Brocoli
                                    <span class="middle">x 02</span>
                                    <span class="last">$720.00</span>
                                </a>
                            </li>
                        </ul>
                        <ul class="list list_2">
                            <li>
                                <a href="#">Subtotal
                                    <span>$2160.00</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">Shipping
                                    <span>Flat rate: $50.00</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">Total
                                    <span>$2210.00</span>
                                </a>
                            </li>
                        </ul>
                        <div class="payment_item">
                            <div class="radion_btn">
                                <input type="radio" id="f-option5" name="selector">
                                <label for="f-option5">Check payments</label>
                                <div class="check"></div>
                            </div>
                            <p>Please send a check to Store Name, Store Street, Store Town, Store State / County, Store
                                Postcode.</p>
                        </div>
                        <div class="payment_item active">
                            <div class="radion_btn">
                                <input type="radio" id="f-option6" name="selector">
                                <label for="f-option6">Paypal </label>
                                <img src="img/product/single-product/card.jpg" alt="">
                                <div class="check"></div>
                            </div>
                            <p>Please send a check to Store Name, Store Street, Store Town, Store State / County, Store
                                Postcode.</p>
                        </div>
                        <div class="creat_account">
                            <input type="checkbox" id="f-option4" name="selector">
                            <label for="f-option4">I’ve read and accept the </label>
                            <a href="#">terms &amp; conditions*</a>
                        </div>
                        <a class="main_btn" href="#">Proceed to Paypal</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
