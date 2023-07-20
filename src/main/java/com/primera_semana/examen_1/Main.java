
package com.primera_semana.examen_1;

import javax.swing.JOptionPane;
/**
 *
 * @author Batres
 */
public class Main {

    public static void main(String[] args) {
       
        double montoTotalFacturado = 0;
        double montoTotalDescuentos = 0;
        double montoTotalIVA = 0;

        while (true) {
            // Solicitar datos del cliente
            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            String correoCliente = JOptionPane.showInputDialog("Ingrese el correo electrónico del cliente:");
            String identificacionCliente = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");
            String telefonoCliente = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");

            // Solicitar datos de los productos
            int numProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de productos a comprar:"));
            double totalCompra = 0;

            String detallesFactura = "********************************************************************************************\n"
                    + "TIENDA FIDELITAS\n"
                    + "Identificación: " + identificacionCliente + "\n"
                    + "Nombre: " + nombreCliente + "\n"
                    + "Correo: " + correoCliente + "\n"
                    + "Teléfono: " + telefonoCliente + "\n"
                    + "********************************************************************************************\n"
                    + "Cantidad // Nombre // Monto IVA // Monto Total\n"
                    + "********************************************************************************************\n";

            for (int i = 0; i < numProductos; i++) {
                String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto " + (i + 1) + ":");
                double precioUnitario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio unitario del producto " + (i + 1) + ":"));
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a comprar del producto " + (i + 1) + ":"));

                double subtotalProducto = precioUnitario * cantidad;
                double montoIVA = subtotalProducto * 0.13; // Porcentaje de IVA del 13%
                subtotalProducto += montoIVA;
                totalCompra += subtotalProducto;
                
                //Impresiones  de los datos de la factura en el String
                detallesFactura += cantidad + " // " + nombreProducto + " //¢" + precioUnitario + " //Con IVA del 13% //  ¢" + subtotalProducto + "\n"; 
            }

            // Calcular descuento
            double descuento = 0;
            if (numProductos >= 5 && numProductos <= 9) {
                descuento = totalCompra * 0.05;
            } else if (numProductos >= 10 && numProductos <= 15) {
                descuento = totalCompra * 0.1;
            } else if (numProductos >= 15) {
                descuento = totalCompra * 0.15;
            }

            // Calcular monto total a pagar
            double montoTotalPagar = totalCompra - descuento;

            // Actualizar montos totales
            montoTotalFacturado += montoTotalPagar;
            montoTotalDescuentos += descuento;
            montoTotalIVA += totalCompra * 0.13; // Porcentaje de IVA del 13%

            detallesFactura += "********************************************************************************************\n"
                    + "Subtotal…………………….. ¢" + totalCompra + "\n"
                    + "Descuento…………………. ¢" + descuento + "\n"
                    + "Total………………………….. ¢" + montoTotalPagar + "\n"
                    + "********************************************************************************************\n";

            JOptionPane.showMessageDialog(null, detallesFactura);

            // Preguntar si desea generar otra factura
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea generar otra factura?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.NO_OPTION) {
                break;
            }
        }

        // Mostrar reportes finales
        String reporteFinal = "======= REPORTES FINALES =======\n"
                + "Monto total facturado: ¢" + montoTotalFacturado + "\n"
                + "Monto total de descuentos aplicados: ¢" + montoTotalDescuentos + "\n"
                + "Monto total del IVA: ¢" + montoTotalIVA + "\n";

        JOptionPane.showMessageDialog(null, reporteFinal);
    }
}
  