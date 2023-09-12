package com.company.billaris2.services.impl;


import com.company.billaris2.DTO.InvoiceDTO;
import com.company.billaris2.entities.Address;
import com.company.billaris2.entities.Invoice;
import com.company.billaris2.entities.Tax;
import com.company.billaris2.mappers.InvoiceMapper;
import com.company.billaris2.repositories.InvoiceRepository;
import com.company.billaris2.services.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapper modelMapper;
    private final AddressService addressService;
    private final TaxService taxService;
    private final DiscountService discountService;
    private final ClientService clientService;
    private final InvoiceStatusService invoiceStatusService;
    private final PaymentMethodService paymentMethodService;
    private final InvoiceLineService invoiceLineService;


    @Override
    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        return optionalInvoice.orElse(null);
    }

    @Override
    public Invoice createInvoice(InvoiceDTO invoiceDTO) {
        // Mapper le DTO vers une entité Invoice
        Invoice invoice = modelMapper.map(invoiceDTO, Invoice.class);


    //    invoice.setAddress(addressService.getAddressById(invoiceDTO.getAddressId()));
        invoice.setTax(taxService.getTaxById(invoiceDTO.getTaxId()));
        invoice.setDiscount(discountService.getDiscountById(invoiceDTO.getDiscountId()));
        invoice.setClient(clientService.getClientById(invoiceDTO.getClientId()));
        invoice.setStatus(invoiceStatusService.getInvoiceStatusById(invoiceDTO.getStatusId()));
        invoice.setPaymentMethod(paymentMethodService.getPaymentMethodById(invoiceDTO.getPaymentMethodId()));
        invoice.setInvoiceLine(invoiceLineService.getInvoiceLineById(invoiceDTO.getInvoiceLineId()));


        // Enregistrer la facture dans le référentiel
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Long id, InvoiceDTO invoiceDTO) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isPresent()) {
            Invoice existingInvoice = optionalInvoice.get();
            // Mettre à jour l'entité Invoice avec les données du DTO
            modelMapper.map(invoiceDTO, existingInvoice);


            // Fetch related entities and update the associations
//            existingInvoice.setAddress(addressService.getAddressById(invoiceDTO.getAddressId()));
            existingInvoice.setTax(taxService.getTaxById(invoiceDTO.getTaxId()));
//            existingInvoice.setDiscount(discountService.getDiscountById(invoiceDTO.getDiscountId()));
//            existingInvoice.setClient(clientService.getClientById(invoiceDTO.getClientId()));
//            existingInvoice.setStatus(invoiceStatusService.getInvoiceStatusById(invoiceDTO.getStatusId()));
//            existingInvoice.setPaymentMethod(paymentMethodService.getPaymentMethodById(invoiceDTO.getPaymentMethodId()));
//            existingInvoice.setInvoiceLine(invoiceLineService.getInvoiceLineById(invoiceDTO.getInvoiceLineId()));


            // Enregistrer la facture mise à jour dans le référentiel
            return invoiceRepository.save(existingInvoice);
        }
        return null; // Facture non trouvée
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }


}
