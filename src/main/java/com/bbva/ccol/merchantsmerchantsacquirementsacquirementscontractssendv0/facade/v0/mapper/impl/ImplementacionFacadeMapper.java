package com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.mapper.impl;

import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.business.dto.*;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.Bank;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.Branch;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.FeeTypeEnum;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.ItemizeFee;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.dto.request.SendRequest;
import com.bbva.ccol.merchantsmerchantsacquirementsacquirementscontractssendv0.facade.v0.mapper.INotificationFacadeMapper;
import org.ehcache.core.util.ByteBufferInputStream;

import javax.xml.crypto.dsig.SignatureMethod;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImplementacionFacadeMapper implements INotificationFacadeMapper {
    @Override
    public BSendRequest sendRequestToBSendRequest(SendRequest request) {

        /************INICIO PRIMER OBJETO**************/
        BItemizeFeeUnit bItemizeFeeUnit = new BItemizeFeeUnit();
            bItemizeFeeUnit.setCurrency(request.getConditions().getFees().getItemizeFees().get(0).getItemizeFeeUnit().getCurrency());

        bItemizeFeeUnit.setUnitType(); //pendiente enum
        bItemizeFeeUnit.setAmount(request.getConditions().getFees().getItemizeFees().get(0).getItemizeFeeUnit().getAmount());

        BItemizeFee bItemizeFee = new BItemizeFee();

        bItemizeFee.setDescription(request.getConditions().getFees().getItemizeFees().get(0).getDescription());
        bItemizeFee.setItemizeFeeUnit(bItemizeFeeUnit);
        bItemizeFee.setFeeType(); //pendiente enum

        List<BItemizeFee> bItemizeFeeList = new ArrayList<>();
        bItemizeFeeList.add(bItemizeFee);

        BFees bFees = new BFees();

        if (request.getConditions().getFees().getItemizeFees() != null && !request.getConditions().getFees().getItemizeFees().isEmpty()){
            bFees.setItemizeFees(new ArrayList<BItemizeFee>());
            for (ItemizeFee itemizeFee:request.getConditions().getFees().getItemizeFees()) {

            }
        }
        bFees.setItemizeFees(bItemizeFeeList);

        BConditions bConditions = new BConditions();
        bConditions.setFees(bFees);
        bConditions.setServiceName(request.getConditions().getServiceName());

        BSendRequest bSendRequest = new BSendRequest();
        bSendRequest.setConditions(bConditions);
        /************FINALIZO PRIMER OBJETO**************/


        /************INICIO SEGUNDO OBJETO**************/
        BBusinessDocumentType bBusinessDocumentType = new BBusinessDocumentType();
        bBusinessDocumentType.setDescription(request.getAcquirementInformation().getBusiness().getBusinessDocument().getDocumentType().getDescription());
        bBusinessDocumentType.setId(); //pendiente enum

        BBusinessDocument bBusinessDocument = new BBusinessDocument();
        bBusinessDocument.setDocumentNumber(request.getAcquirementInformation().getBusiness().getBusinessDocument().getDocumentNumber());
        bBusinessDocument.setVerificationDigit(request.getAcquirementInformation().getBusiness().getBusinessDocument().getVerificationDigit());
        bBusinessDocument.setDocumentType(bBusinessDocumentType);

        BLocation bLocation = new BLocation();
        bLocation.setFormattedAddress(request.getAcquirementInformation().getBusiness().getMailingAddress().getAddress().getLocation().getFormattedAddress());

        BAddress bAddress = new BAddress();
        bAddress.setLocation(bLocation);

        BMailingAddress bMailingAddress = new BMailingAddress();
        bMailingAddress.setEmail(request.getAcquirementInformation().getBusiness().getMailingAddress().getEmail());
        bMailingAddress.setState(request.getAcquirementInformation().getBusiness().getMailingAddress().getState());
        bMailingAddress.setCityName(request.getAcquirementInformation().getBusiness().getMailingAddress().getCityName());
        bMailingAddress.setDaneCode(request.getAcquirementInformation().getBusiness().getMailingAddress().getDaneCode());
        bMailingAddress.setMobileNumber(request.getAcquirementInformation().getBusiness().getMailingAddress().getMobileNumber());
        bMailingAddress.setPostalCode(request.getAcquirementInformation().getBusiness().getMailingAddress().getPostalCode());
        bMailingAddress.setPhoneNumber(request.getAcquirementInformation().getBusiness().getMailingAddress().getPhoneNumber());
        bMailingAddress.setAddress(bAddress);

        BStore bStore = new BStore();
        bStore.setState(request.getAcquirementInformation().getBusiness().getStores().get(0).getState());
        bStore.setCityName(request.getAcquirementInformation().getBusiness().getStores().get(0).getCityName());
        bStore.setDaneCode(request.getAcquirementInformation().getBusiness().getStores().get(0).getDaneCode());
        bStore.setPhoneNumber(request.getAcquirementInformation().getBusiness().getStores().get(0).getPhoneNumber());
        bStore.setPointOfSaleId(request.getAcquirementInformation().getBusiness().getStores().get(0).getPointOfSaleId());
        bStore.setRadicationNumberMaster(request.getAcquirementInformation().getBusiness().getStores().get(0).getRadicationNumberMaster());
        bStore.setRadicationNumberVisa(request.getAcquirementInformation().getBusiness().getStores().get(0).getRadicationNumberVisa());
        bStore.setAddress(bAddress);
        bStore.setSaleType(); //pendiente enum



        List<BStore> bStoreList = new ArrayList<>();
        bStoreList.add(bStore);

        BTaxResponsibility bTaxResponsibility = new BTaxResponsibility();
        bTaxResponsibility.setCode(request.getAcquirementInformation().getBusiness().getTaxResponsibilities().get(0).getCode());

        List<BTaxResponsibility> bTaxResponsibilityList = new ArrayList<>();
        bTaxResponsibilityList.add(bTaxResponsibility);

        BBusiness bBusiness = new BBusiness();
        bBusiness.setId(request.getAcquirementInformation().getBusiness().getId());
        bBusiness.setDoingBusinessAs(request.getAcquirementInformation().getBusiness().getDoingBusinessAs());
        bBusiness.setLegalName(request.getAcquirementInformation().getBusiness().getLegalName());
        bBusiness.setEconomicActivity(request.getAcquirementInformation().getBusiness().getEconomicActivity());
        bBusiness.setCommercialActivity(request.getAcquirementInformation().getBusiness().getCommercialActivity());
        bBusiness.setCommercialRegister(request.getAcquirementInformation().getBusiness().getCommercialRegister());
        bBusiness.setMerchantCategoryCode(request.getAcquirementInformation().getBusiness().getMerchantCategoryCode());
        bBusiness.setMerchantCategoryCodeReal(request.getAcquirementInformation().getBusiness().getMerchantCategoryCodeReal());
        bBusiness.setBusinessDocument(bBusinessDocument);
        bBusiness.setMailingAddress(bMailingAddress);
        bBusiness.setStores(bStoreList);
        bBusiness.setTaxResponsibilities(bTaxResponsibilityList);

        BCurrencyAmount bCurrencyAmount = new BCurrencyAmount();
        bCurrencyAmount.setAmount(request.getAcquirementInformation().getFinancialInformation().getAssets().getAmount());
        bCurrencyAmount.setCurrency(request.getAcquirementInformation().getFinancialInformation().getAssets().getCurrency());


        BFinancialInformation bFinancialInformation = new BFinancialInformation();
        if (request.getAcquirementInformation().getFinancialInformation() != null){
            bFinancialInformation.setDescription(request.getAcquirementInformation().getFinancialInformation().getDescription());
            bFinancialInformation.setOriginOfFundsDeclaration(request.getAcquirementInformation().getFinancialInformation().getOriginOfFundsDeclaration());
            bFinancialInformation.setAssets(bCurrencyAmount);
            bFinancialInformation.setLiabilities(bCurrencyAmount);///
            bFinancialInformation.setMonthlyIncomes(bCurrencyAmount);
            bFinancialInformation.setMonthlyExpenses(bCurrencyAmount);
            bFinancialInformation.setOtherIncomes(bCurrencyAmount);
        }

        BInstallationData bInstallationData = new BInstallationData();
        if (request.getAcquirementInformation().getInstallationData() != null){
            bInstallationData.setDataphoneType(); //pendiente enum
            bInstallationData.setSchedule(); //pendiente enum
        }

       BDocumentType bDocumentType = new BDocumentType();
       bDocumentType.setDescription(request.getAcquirementInformation().getLegalRepresentative().getIdentityDocument().getDocumentType().getDescription());
       bDocumentType.setId(); //enum

        BIdentityDocument bIdentityDocument = new BIdentityDocument();
        bIdentityDocument.setDocumentNumber(request.getAcquirementInformation().getLegalRepresentative().getIdentityDocument().getDocumentNumber());
        bIdentityDocument.setDocumentType(bDocumentType);
        //convirtiendo Date a string
        String fecha = request.getAcquirementInformation().getLegalRepresentative().getIdentityDocument().getExpeditionDate();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date = format.parse(fecha);
            bIdentityDocument.setExpeditionDate(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }


        BLegalRepresentative bLegalRepresentative = new BLegalRepresentative();
        bLegalRepresentative.setEmail(request.getAcquirementInformation().getLegalRepresentative().getEmail());
        bLegalRepresentative.setCity(request.getAcquirementInformation().getLegalRepresentative().getCity());
        bLegalRepresentative.setMobileNumber(request.getAcquirementInformation().getLegalRepresentative().getMobileNumber());
        bLegalRepresentative.setPhoneNumber(request.getAcquirementInformation().getLegalRepresentative().getPhoneNumber());
        bLegalRepresentative.setGender(); //enum
        bLegalRepresentative.setFirstLastName(request.getAcquirementInformation().getLegalRepresentative().getFirstLastName());
        bLegalRepresentative.setFirstName(request.getAcquirementInformation().getLegalRepresentative().getFirstName());
        bLegalRepresentative.setMiddleName(request.getAcquirementInformation().getLegalRepresentative().getMiddleName());
        bLegalRepresentative.setSecondLastName(request.getAcquirementInformation().getLegalRepresentative().getSecondLastName());
        bLegalRepresentative.setAddress(bAddress);
        bLegalRepresentative.setIdentityDocument(bIdentityDocument);
        bLegalRepresentative.setShareholdingPercentage(request.getAcquirementInformation().getLegalRepresentative().getShareholdingPercentage());

        BBranch bBranch = new BBranch();
        if (request.getAcquirementInformation().getRelatedContract().getBank().getBranch() != null){
            bBranch.setId(request.getAcquirementInformation().getRelatedContract().getBank().getBranch().getId());
            bBranch.setName(request.getAcquirementInformation().getRelatedContract().getBank().getBranch().getName());
        }

        BBank bBank = new BBank();
        bBank.setBranch(bBranch);

        BRelatedContract bRelatedContract = new BRelatedContract();
        bRelatedContract.setNumber(request.getAcquirementInformation().getRelatedContract().getNumber());
        bRelatedContract.setBank(bBank);



        BShareholder bShareholder = new BShareholder();
        bShareholder.setShareholdingPercentage(request.getAcquirementInformation().getShareholders().get(0).getShareholdingPercentage());
        bShareholder.setIdentityDocument(bIdentityDocument);
        bShareholder.setFullName(request.getAcquirementInformation().getShareholders().get(0).getFullName());
        List<BShareholder> bShareholderList = new ArrayList<>();
        bShareholderList.add(bShareholder);

        BAcquirementInformation bAcquirementInformation = new BAcquirementInformation();
        bAcquirementInformation.setBusiness(bBusiness);
        bAcquirementInformation.setFinancialInformation(bFinancialInformation);
        bAcquirementInformation.setFiledCity(request.getAcquirementInformation().getFiledCity());
        bAcquirementInformation.setInstallationData(bInstallationData);
        bAcquirementInformation.setLegalRepresentative(bLegalRepresentative);
        bAcquirementInformation.setRelatedContract(bRelatedContract);
        bAcquirementInformation.setShareholders(bShareholderList);
        //aca vamos************************************************************
        //convirtiendo Date a string
        String fecha1 = request.getAcquirementInformation().getCompletionDate();
        try {
            Date date = format.parse(fecha1);
            bAcquirementInformation.setCompletionDate(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        bSendRequest.setAcquirementInformation(bAcquirementInformation);
        /************FINALIZO SEGUNDO OBJETO**************/

        /************INICIO TERCER OBJETO**************/
        BBusinessAgent bBusinessAgent = new BBusinessAgent();
        bBusinessAgent.setId(request.getContractInformation().getBusinessAgent().getId());


        BContractInformation bContractInformation = new BContractInformation();
        if (request.getContractInformation().getBusinessAgent() != null){
            bContractInformation.setReference(request.getContractInformation().getReference());
            bContractInformation.setBusinessAgent(bBusinessAgent);
        }

        bSendRequest.setContractInformation(bContractInformation);
        /************FINALIZO TERCER OBJETO**************/





        return bSendRequest;

    }
}
